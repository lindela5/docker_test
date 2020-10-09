package com.innowise.darya.controller;

import com.innowise.darya.entity.BookEntity;
import com.innowise.darya.dto.BookEntityDTO;
import com.innowise.darya.transformer.BookDTOTransformer;
import com.innowise.darya.service.BookService;
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
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)


    public ResponseEntity<BookEntityDTO> getBookStats(@PathVariable final Long id) {
        BookEntity book = bookService.getBookStats(id);
        BookEntityDTO bookEntityDTO = BookDTOTransformer.TRANSFORMER.bookEntityToBookEntityDTO(book);
        return ResponseEntity.ok(bookEntityDTO);
    }
}