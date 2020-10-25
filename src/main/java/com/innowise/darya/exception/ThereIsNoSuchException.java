package com.innowise.darya.exception;

public class ThereIsNoSuchException extends RuntimeException {

    public ThereIsNoSuchException() {
    }

    public ThereIsNoSuchException(String message) {
        super(message);
    }
}
