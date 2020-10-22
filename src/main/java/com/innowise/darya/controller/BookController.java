package com.innowise.darya.controller;

import com.innowise.darya.entity.Book;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.transformer.BookDTOTransformer;
import com.innowise.darya.service.BookService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/book")
@Log
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)


    public ResponseEntity<BookDTO> getBookStats(@PathVariable final Long bookId) {
        Book book = bookService.getBookStats(bookId);
       // log.info("Isbn книги - "+book.getIsbn()+" название - "+ book.getTitle());
        BookDTO bookDTO = BookDTOTransformer.BOOK_DTO_TRANSFORMER.bookToBookDTO(book);
        return ResponseEntity.ok(bookDTO);
    }
}