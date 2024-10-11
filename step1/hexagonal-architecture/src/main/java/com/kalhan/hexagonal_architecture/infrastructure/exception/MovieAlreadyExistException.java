package com.kalhan.hexagonal_architecture.infrastructure.exception;

public class MovieAlreadyExistException extends RuntimeException{
    public MovieAlreadyExistException(String message) {
        super(message);
    }
}
