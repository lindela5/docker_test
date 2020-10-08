package com.example.docker_test.controller;

import com.example.docker_test.domen.BookEntity;
import com.example.docker_test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService restService) {
        this.bookService = restService;
    }
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    //@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<BookEntity> getBookStats(@PathVariable final Long id) {
           return ResponseEntity.ok(bookService.getBookStats(id));
    }}