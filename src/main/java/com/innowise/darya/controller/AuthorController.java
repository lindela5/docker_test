package com.innowise.darya.controller;

import com.innowise.darya.service.AuthorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    private AuthorService authorService;
}
