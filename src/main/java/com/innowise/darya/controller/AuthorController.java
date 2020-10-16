package com.innowise.darya.controller;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.entity.Author;
import com.innowise.darya.service.AuthorService;
import com.innowise.darya.transformer.AuthorDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "{authorId}", produces = MediaType.APPLICATION_JSON_VALUE)


    public ResponseEntity<AuthorDTO> getAuthorStats(@PathVariable final Long authorId) {
        Author author = authorService.getAuthorStats(authorId);
        AuthorDTO authorDTO = AuthorDTOTransformer.AUTHOR_DTO_TRANSFORMER.authorToAuthorDTO(author);
        return ResponseEntity.ok(authorDTO);
    }
}
