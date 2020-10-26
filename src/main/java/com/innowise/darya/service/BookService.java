package com.innowise.darya.service;

import com.innowise.darya.entity.Book;
import com.innowise.darya.exception.ThereIsNoSuchException;
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


    public Book getBookStats(Long bookId) {
        Book book = bookRepository.findByBookId(bookId);
        if (book == null) {
            log.error("There is no such book");
            throw new ThereIsNoSuchException();
        }

        return book;
    }
}
