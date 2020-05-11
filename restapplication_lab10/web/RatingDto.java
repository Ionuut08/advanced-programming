package com.example.ionut.restapplication.web;

import com.example.ionut.restapplication.domain.GameRating;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class RatingDto {

    @Min(0)
    @Max(5)
    private int score;

    @Size(max = 255)
    private String comment;

    @NonNull
    private int playerId;

    public RatingDto(GameRating gameRating) {
        this(gameRating.getScore(), gameRating.getComment(), gameRating.getPlayerId());
    }

    public RatingDto(Integer score, String comment, Integer playerId) {
        this.score = score;
        this.comment = comment;
        this.playerId = playerId;
    }

    protected RatingDto() {}

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
