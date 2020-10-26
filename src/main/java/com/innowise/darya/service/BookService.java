package com.innowise.darya.service;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.Author;
import com.innowise.darya.entity.Book;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

//@Service
//@Transactional
//@Slf4j
public interface BookService {
    /*private BookRepository bookRepository;

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
    }*/
    List<BookDTO> getAllBook();

    BookDTO getBookById(long id);

    Book addBook(Book book);

    //void delBook(long id);

    ResponseEntity<Object> updBook(Book book, long id);

    List<AuthorDTO> getAuthorByYearOfIssue(Integer yearOfIssue);

  //  List<String> getBookByYearOfIssue(Integer yearOfIssue);


}
//}
