package com.example.ionut.restapplication.services;

import com.example.ionut.restapplication.domain.Division;
import com.example.ionut.restapplication.domain.Game;
import com.example.ionut.restapplication.domain.Player;
import com.example.ionut.restapplication.repo.GameRepository;
import com.example.ionut.restapplication.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    private GameRepository gameRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, GameRepository gameRepository) {
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
    }

    public Player createPlayer(String firstName, String lastName,
                               Division division, String gameName) {
        Game game = gameRepository.findByName(gameName)
                .orElseThrow(() -> new RuntimeException("Game does not exist " + gameName));

        return playerRepository.save(new Player(firstName, lastName, division, game));
    }


    public long total() {
        return playerRepository.count();
    }
}
