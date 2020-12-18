package com.innowise.darya.controller;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.service.AuthorService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/author")
@Log
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }



    @GetMapping("/getbyid/{id}")
    public AuthorDTO getAuthorById(@PathVariable long id){
        return authorService.getAuthorById(id);
    }


    @PostMapping("/save")
    public AuthorDTO saveAuthor(@RequestBody AuthorDTO authorDto) {
        log.info("Handling save users: " + authorDto);
        return authorService.saveAuthor(authorDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable String id) {
        log.info("Handling delete user request: " + id);
        authorService.deleteAuthor(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }
}
