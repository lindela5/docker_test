package com.innowise.darya.controller;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.entity.Book;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.service.AuthorService;
import com.innowise.darya.transformer.BookDTOTransformer;
import com.innowise.darya.service.BookService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
//@RequestMapping(path = "/book")
@Log
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("title", "Book");
        return "index";
    }

    @PostMapping("filter")
    public String filter( @RequestParam String year, Map<String, Object> model) {
        Set<AuthorDTO> items = new HashSet<>();

        if (year != null && !year.isEmpty()) {
            items = bookService.getAuthorByYear(year);
        }

        if (!items.isEmpty()) {
            model.put("items", items);
        }
        model.put("title", "Books");
        return "index";
    }

    @GetMapping("/all")
    public List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getbyid/{id}")
    public BookDTO getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    //найти всех авторов, которые издавались в этот год
    @GetMapping("/getauthorbyyear/{year}")
    public Set<AuthorDTO> getAuthorByYear(@PathVariable String year) {
        return bookService.getAuthorByYear(year);
    }

//    @GetMapping(value = {"/", "/index"})
//   public String index(Model model) {
//        model.addAttribute("title", "Book");
//        return "index";
//    }
//
//    @PostMapping("filter")
//    public String filter(@RequestParam Integer year, Map<String, Object> model) {
//        Set<AuthorDTO> author = new HashSet<>();
//
//            author = bookService.getAuthorByYear(year);
//
//            model.put("items", author);
//
//        return "index";
//    }
}