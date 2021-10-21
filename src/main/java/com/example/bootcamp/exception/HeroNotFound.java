package com.example.bootcamp.exception;

public class HeroNotFound extends RuntimeException {
    public HeroNotFound() {
        super("Hero not found");
    }
    public HeroNotFound(String message) {
        super(message);
    }
}
