package com.example.ionut.restapplication.web;

public class PlayerNotFoundException extends RuntimeException{

    PlayerNotFoundException(int id) {
        super("Could not find player " + id);
    }
}
