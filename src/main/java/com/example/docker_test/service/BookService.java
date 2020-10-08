package com.example.docker_test.service;

import com.example.docker_test.domen.BookEntity;
import com.example.docker_test.repositoty.BookRepository;
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
      //  String result="{ID : "+book.getId().toString()+",Title : "+book.getTitle()+",Author :"+ book.getAuthor()+",Year of issue :"+ book.getYearOfIssue()+" }";

        return book;
    }
}
