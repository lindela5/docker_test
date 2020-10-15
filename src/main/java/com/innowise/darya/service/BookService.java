package com.innowise.darya.service;

import com.innowise.darya.entity.BookEntity;
import com.innowise.darya.exception.ThereIsNoSuchBookException;
import com.innowise.darya.repositoty.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public BookEntity getBookStats(Long bookId) {
        BookEntity book = bookRepository.findByBookId(bookId);
        if (book == null) {
            log.error("There is no such book");
            throw new ThereIsNoSuchBookException();
        }

        return book;
    }
}
