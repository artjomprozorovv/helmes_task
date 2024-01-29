package com.tennis.java.exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message, Exception e) {
        super(message,e);
    }
}
