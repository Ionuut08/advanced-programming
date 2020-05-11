package com.example.ionut.restapplication.repo;

import com.example.ionut.restapplication.domain.Game;
import com.example.ionut.restapplication.domain.GameRating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface GameRatingRepository extends CrudRepository<GameRating, Integer> {

    /* Returns a list of all game ratings*/
    List<GameRating> findByGameId(int gameId);

    /* Returns one unique game rating */
    Optional<GameRating> findByGameIdAndPlayerId(int gameId, int playerId);

    Page<GameRating> findByGameId(int gameId, Pageable pageable);

}
