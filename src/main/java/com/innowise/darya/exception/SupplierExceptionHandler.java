package com.innowise.darya.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SupplierExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNoSuchException.class)
    protected ResponseEntity<SupplierException> handleThereIsNoSuchSupplierException() {
        return new ResponseEntity<>(new SupplierException("There is no such supplier"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class SupplierException {
        private String message;
    }
}