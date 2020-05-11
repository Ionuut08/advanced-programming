package com.example.ionut.restapplication.services;

import com.example.ionut.restapplication.domain.Game;
import com.example.ionut.restapplication.domain.Player;
import com.example.ionut.restapplication.repo.GameRepository;
import com.example.ionut.restapplication.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game createGame(int id, String name, String division,
                                        String difficulty) {
        return gameRepository.findById(id)
                .orElse(gameRepository.save(new Game(id, name, division, difficulty)));
    }

    public Iterable<Game> lookup() {
        return gameRepository.findAll();
    }

    public long total() {
        return gameRepository.count();
    }

}
