package com.innowise.darya.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SupplyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNoSuchSupplyException.class)
    protected ResponseEntity<SupplyException> handleThereIsNoSuchSupplyException() {
        return new ResponseEntity<>(new SupplyException("There is no such supply"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class SupplyException {
        private String message;
    }
}
