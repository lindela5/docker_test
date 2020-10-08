package com.example.docker_test.controller;

import com.example.docker_test.domen.BookEntity;
import com.example.docker_test.dto.BookEntityDTO;
import com.example.docker_test.mappers.BookDTOTransformer;
import com.example.docker_test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<BookEntityDTO> getBookStats(@PathVariable final Long id) {
        BookEntity book = bookService.getBookStats(id);
        BookEntityDTO bookEntityDTO = BookDTOTransformer.TRANSFORMER.bookEntityToBookEntityDTO(book);
        return ResponseEntity.ok(bookEntityDTO);
    }
}