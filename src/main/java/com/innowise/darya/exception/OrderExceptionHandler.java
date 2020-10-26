package com.innowise.darya.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class OrderExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNoSuchException.class)
    protected ResponseEntity<OrderException> handleThereIsNoSuchOrderException() {
        return new ResponseEntity<>(new OrderException("There is no such order"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class OrderException {
        private String message;
    }
}