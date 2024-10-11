package com.kalhan.hexagonal_architecture.infrastructure.exception;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(String message) {
        super(message);
    }
}
