package com.example.ionut.restapplication.repo;

import com.example.ionut.restapplication.domain.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Integer> {
    Optional<Game> findByName(String name);
}
