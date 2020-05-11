package com.example.ionut.restapplication.domain;

import javax.persistence.*;

@Entity
@Table(name = "game_rating")
public class GameRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game  game;

    @Column(name = "player_id")
    private int playerId;

    @Column(nullable = false)
    private Integer score;

    @Column
    private String comment;
//
//    @ManyToOne
//    @JoinColumn
//    private Game game;

    public GameRating(Game game, int playerId, int score, String comment) {
        this.game=game;
        this.playerId = playerId;
        this.score = score;
        this.comment = comment;
    }

    public GameRating() {}

    public GameRating(Game game, int playerId, int score) {
        this.game = game;
        this.playerId = playerId;
        this.score = score;

    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
