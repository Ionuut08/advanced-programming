package com.example.ionut.restapplication.services;

import com.example.ionut.restapplication.domain.Game;
import com.example.ionut.restapplication.domain.GameRating;
import com.example.ionut.restapplication.repo.GameRatingRepository;
import com.example.ionut.restapplication.repo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

/* We will use spring transactions because the state of the data should appear
* as the service was never invoked */

@Service
@Transactional
public class GameRatingService {

    GameRepository gameRepository;
    GameRatingRepository gameRatingRepository;

    @Autowired
    public GameRatingService(GameRatingRepository gameRatingRepository,
                                GameRepository gameRepository) {
        this.gameRatingRepository = gameRatingRepository;
        this.gameRepository = gameRepository;
    }

    public void createNew(int gameId, int playerId, int score, String comment) throws NoSuchElementException {
        gameRatingRepository.save(new GameRating(verifyGame(gameId), playerId, score,comment));
    }

    public Page<GameRating> lookupRatings(int gameId, Pageable pageable) throws NoSuchElementException {
        return gameRatingRepository.findByGameId(verifyGame(gameId).getId(), pageable);
    }

    @Transactional
    public void rateMany(int gameId, int score, Integer [] players) {
        gameRepository.findById(gameId).ifPresent(game -> {
            for (Integer p : players) {
                gameRatingRepository.save(new GameRating(game, p, score));
            }
        });
    }

    public void createMany(int gameId, int playerId, int rating, String comment) throws NoSuchElementException {
        gameRatingRepository.save(new GameRating(verifyGame(gameId), playerId, rating, comment));
    }

    public GameRating update(int gameId, int playerId, int rating, String comment) throws NoSuchElementException {
        GameRating gameRating = verifyGameRating(gameId, playerId);
        gameRating.setScore(rating);
        gameRating.setComment(comment);
        return gameRatingRepository.save(gameRating);
    }

    public void delete(int gameId, int playerId) throws NoSuchElementException {
        GameRating gameRating = verifyGameRating(gameId, playerId);
        gameRatingRepository.delete(gameRating);
    }


    private Game verifyGame(int gameId) throws NoSuchElementException {
        return gameRepository.findById(gameId).orElseThrow(() ->
                new NoSuchElementException("Game does not exist"));
    }

    private GameRating verifyGameRating(int gameId, int playerId) throws NoSuchElementException {
        return gameRatingRepository.findByGameIdAndPlayerId(gameId, playerId)
                .orElseThrow(() -> new NoSuchElementException("GameRating pair for " +
                        "request" + gameId + "for player" + playerId));
    }

}
