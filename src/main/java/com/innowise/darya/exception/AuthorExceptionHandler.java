package com.innowise.darya.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AuthorExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNoSuchException.class)
    protected ResponseEntity<AuthorException> handleThereIsNoSuchAuthorException() {
        return new ResponseEntity<>(new AuthorException("There is no such author"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class AuthorException {
        private String message;
    }
}