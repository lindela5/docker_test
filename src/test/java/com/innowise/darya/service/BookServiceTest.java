package com.innowise.darya.service;


import com.innowise.darya.repositoty.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;


class BookServiceTest {

 @Mock
    BookRepository bookRepository;

    @Test
    public void testGetBookStats(){

        BookService bookService = new BookService();

        given(bookRepository.findById(Long id)).willReturn(bookEntity);

    }

}