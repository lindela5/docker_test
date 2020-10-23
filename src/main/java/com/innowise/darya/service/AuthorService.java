package com.innowise.darya.service;

import com.innowise.darya.entity.Author;
import com.innowise.darya.exception.ThereIsNoSuchAuthorException;
import com.innowise.darya.repositoty.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public Author getAuthorStats(Long authorId) {
        Author author = authorRepository.findByAuthorId(authorId);
        if (author == null) {
            throw new ThereIsNoSuchAuthorException();
        }

        return author;
    }
}
