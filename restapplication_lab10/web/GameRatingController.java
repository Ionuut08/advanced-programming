package com.example.ionut.restapplication.web;

import com.example.ionut.restapplication.domain.Game;
import com.example.ionut.restapplication.domain.GameRating;
import com.example.ionut.restapplication.repo.GameRatingRepository;
import com.example.ionut.restapplication.repo.GameRepository;
import com.example.ionut.restapplication.services.GameRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/games/{gameId}/ratings")
public class GameRatingController {
    GameRatingRepository gameRatingRepository;
    GameRepository gameRepository;
    private GameRatingService gameRatingService;

    @Autowired
    public GameRatingController (GameRatingRepository gameRatingRepository,
                                    GameRepository gameRepository) {
        this.gameRatingRepository = gameRatingRepository;
        this.gameRepository = gameRepository;
    }

    protected GameRatingController() {}

    /* POST RATING */

    @PostMapping
    @PreAuthorize("hasRole('ROLE_GC')")
    @ResponseStatus(HttpStatus.CREATED)
    public void createGameRating(@PathVariable(value = "gameId") int gameId,
                                 @RequestBody @Validated RatingDto ratingDto) {
        gameRatingService.createNew(gameId, ratingDto.getPlayerId(), ratingDto.getScore(), ratingDto.getComment());
    }

    /*
     * Create Several Game Ratings for one game, score and several players.
     */

    @PostMapping("/{rating}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createManyGameRatings(@PathVariable(value = "gameId") int gameId,
                                      @PathVariable(value = "rating") int rating,
                                      @RequestParam("players") Integer players[]) {
        gameRatingService.rateMany(gameId, rating, players);
    }

    @GetMapping
    public Page<RatingDto> getAllRatingsForGame(@PathVariable(value = "gameId") int gameId, Pageable pageable) {
        verifyGame(gameId);

        Page<GameRating> ratings = gameRatingRepository.findByGameId(gameId, pageable);
        return new PageImpl<>(
                ratings.get().map(RatingDto::new).collect(Collectors.toList()),
                pageable,
                ratings.getTotalElements()
        );
//        return gameRatingRepository.findByPkGameId(gameId).stream()
//                .map(RatingDto::new).collect(Collectors.toList());

//        http://localhost:8081/games/1/ratings?size=2&page=1&sort=score,desc
    }



    @GetMapping(path = "/average")
    public Map<String, Double> getAverage(@PathVariable(value = "gameId") int gameId) {
        verifyGame(gameId);
        return Map.of("average", gameRatingRepository.findByGameId(gameId).stream()
                    .mapToInt(GameRating::getScore).average()
                    .orElseThrow(() -> new NoSuchElementException("Game has no ratings")));

    }

    @PutMapping
    public RatingDto updateWithPut(@PathVariable(value = "gameId") int gameId,
                                   @RequestBody @Validated RatingDto ratingDto) {
        GameRating gameRating = verifyGameRating(gameId, ratingDto.getPlayerId());
        gameRating.setScore(ratingDto.getScore());
        gameRating.setComment(ratingDto.getComment());
        return new RatingDto(gameRatingRepository.save(gameRating));
    }

    @PatchMapping
    public RatingDto updateWithPatch(@PathVariable(value = "gameId") int gameId,
                                     @RequestBody @Validated RatingDto ratingDto) {
        GameRating gameRating = verifyGameRating(gameId, ratingDto.getPlayerId());
        if (ratingDto.getScore() != 0) {
            gameRating.setScore(ratingDto.getScore());
        }
        if (ratingDto.getComment() != null) {
            gameRating.setComment(ratingDto.getComment());
        }
        return new RatingDto(gameRatingRepository.save(gameRating));
    }

    @DeleteMapping(path = "/{playerId}")
    public void delete(@PathVariable(value = "gameId") int gameId,
                       @PathVariable(value = "playerId") int playerId) {
        GameRating gameRating = verifyGameRating(gameId, playerId);
        gameRatingRepository.delete(gameRating);
    }


    private GameRating verifyGameRating(int gameId, int playerId) throws NoSuchElementException {
        return gameRatingRepository.findByGameIdAndPlayerId(gameId, playerId).orElseThrow(() ->
                new NoSuchElementException("Game-Rating pair for request( " + gameId + " for player " + playerId ));

    }

    private Game verifyGame(int gameId) throws NoSuchElementException {
        return gameRepository.findById(gameId).orElseThrow(() ->
                new NoSuchElementException("Game does not exist " + gameId));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400 (NoSuchElementException exception){
        return exception.getMessage();
    }
}
