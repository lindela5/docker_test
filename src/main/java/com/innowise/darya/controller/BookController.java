package com.innowise.darya.controller;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.service.BookService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/books")
@Log
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }



    @GetMapping("/findAll")
    public List<BookDTO> getAllBooks(){
        log.info("Handling find all users request");
        return bookService.getAllBooks();
    }

    @GetMapping("/getbyid/{id}")
    public BookDTO getBookById(@RequestParam long id) {
        log.info("Handling find by id request: " + id);
        return bookService.getBookById(id);
    }



    //найти всех авторов, которые издавались в этот год
    @GetMapping("/getauthorbyyear/{year}")
    public Set<AuthorDTO> getAuthorByYear(@PathVariable String year) {
        return bookService.getAuthorByYear(year);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        log.info("Handling delete user request: " + id);
        bookService.deleteBook(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }

    //в каких секциях лежат книги
    @GetMapping("/getbysection/{section}")
    public List<BookDTO> getBooksBySection(@RequestParam long section){
        return bookService.getBooksBySection(section);
    }


}