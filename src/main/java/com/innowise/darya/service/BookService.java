package com.innowise.darya.service;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.Book;

import java.util.List;
import java.util.Set;


public interface BookService {

   // List<Book> findAll();

    BookDTO getBookById(long id);

    Set<AuthorDTO> getAuthorByYear(Integer year);


}

