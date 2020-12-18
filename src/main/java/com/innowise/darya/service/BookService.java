package com.innowise.darya.service;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.BookDTO;

import java.util.List;
import java.util.Set;


public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO getBookById(long id);

    Set<AuthorDTO> getAuthorByYear(String year);

    BookDTO saveBook(BookDTO bookDto);

    void deleteBook(long bookId);

        List<BookDTO> getBooksBySection(long id);

}

