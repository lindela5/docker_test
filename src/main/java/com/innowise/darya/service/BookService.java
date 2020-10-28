package com.innowise.darya.service;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.dto.SupplyDTO;
import com.innowise.darya.entity.Author;
import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Supply;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.BookRepository;
import com.innowise.darya.transformer.BookDTOTransformer;
import com.innowise.darya.transformer.SupplyDTOTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
            throw new ThereIsNoSuchException("book");
        }

        return book;
    }


    public BookDTO getBookById(long id) {
        Optional<Book> bookOptional = Optional.ofNullable(bookRepository.findByBookId(id));
        if (!bookOptional.isPresent()){
            return null;
        }
        Book book = bookOptional.get();
        if (book == null) {
            log.error("There is no such book");
            throw new ThereIsNoSuchException("book");
        }

        BookDTO bookDTO = BookDTOTransformer.BOOK_DTO_TRANSFORMER.bookToBookDTO(book);
        return bookDTO;
    }

}
//}
