package com.example.ionut.restapplication.web;

import com.example.ionut.restapplication.domain.Player;
import com.example.ionut.restapplication.repo.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    List<Player> all() {
        return (List<Player>) playerRepository.findAll();
    }

    @GetMapping("/players/{id}")
    Player one(@PathVariable int id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Player newPlayer(@RequestBody Player newPlayer) {
        return playerRepository.save(newPlayer);
    }

    @PutMapping("/players/{id}")
    Player replacePlayerName(@RequestBody Player newPlayer,
                             @PathVariable int id) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setFirstName(newPlayer.getFirstName());
                    player.setLastName(newPlayer.getLastName());
                    return playerRepository.save(player);
                })
                .orElseGet(() -> {
                    newPlayer.setId(id);
                    return playerRepository.save(newPlayer);
                });
    }

    @DeleteMapping
    void deletePlayer(@PathVariable int id) {
        playerRepository.deleteById(id);
    }
}
