package com.innowise.darya.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNoSuchBookException.class)
    protected ResponseEntity<BookException> handleThereIsNoSuchBookException() {
        return new ResponseEntity<>(new BookException("There is no such book"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class BookException {
        private String message;
    }
}
