package com.innowise.darya.controller;

import com.innowise.darya.security.SecurityUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private UserDetailsService userDetailsServiceImpl;

    public AuthController(UserDetailsService userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @PostMapping("/authenticate")
    //
    public ResponseEntity<String> getLoginPage(@RequestParam String login, @RequestParam String password) {
        System.out.println(login + " " + password);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @GetMapping("/success")
    //
    public String getSuccessPage() {
        return "success";
    }
}