package com.innowise.darya.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SectionExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNoSuchException.class)
    protected ResponseEntity<SectionException> handleThereIsNoSuchSectionException() {
        return new ResponseEntity<>(new SectionException("There is no such section"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class SectionException {
        private String message;
    }
}
