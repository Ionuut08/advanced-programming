package com.example.ionut.restapplication.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "games")
public class Game implements Serializable {

    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String division;

    @Column
    private String difficulty;

    @Column
    private int bestScore;


    public Game(int id, String name, String division, String difficulty) {
        this.id = id;
        this.name = name;
        this.division = division;
        this.difficulty = difficulty;
    }

    public Game() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }
}
