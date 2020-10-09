package com.innowise.darya.service;

import com.innowise.darya.entity.BookEntity;
import com.innowise.darya.exception.ThereIsNoSuchBookException;
import com.innowise.darya.repositoty.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity getBookStats(Long id){
        BookEntity book= bookRepository.findById(id);
        if (book == null) {
            throw new ThereIsNoSuchBookException();
        }

        return book;
    }
}
