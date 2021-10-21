package com.example.bootcamp.exception;

public class SuperPowerNotFound extends RuntimeException {
    public SuperPowerNotFound() {
        super("SuperPower not found in Database");
    }
    public SuperPowerNotFound(String message) {
        super(message);
    }
}
