package com.innowise.darya.service;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.Author;
import com.innowise.darya.entity.Book;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.BookRepository;
import com.innowise.darya.transformer.AuthorDTOTransformer;
import com.innowise.darya.transformer.BookDTOTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        for (Book book : bookList) {
            bookDTOList.add(BookDTOTransformer.BOOK_DTO_TRANSFORMER.bookToBookDTO(book));
        }
        return bookDTOList;
    }


    @Override
    public BookDTO getBookById(long id) {
        Optional<Book> book = Optional.ofNullable(bookRepository.findByBookId(id));
        if (!book.isPresent()) {
            log.error("There is no such book");
            throw new ThereIsNoSuchException("book");
        }
        BookDTO bookDTO = BookDTOTransformer.BOOK_DTO_TRANSFORMER.bookToBookDTO(book.get());
        return bookDTO;
    }

    @Override
    public Set<AuthorDTO> getAuthorByYear(String year) {
        Integer yearOfIssue = Integer.valueOf(year);
        Set<Book> bookSet = bookRepository.findBookByYearOfIssue(yearOfIssue);
        Set<Set<Author>> bookAuthorSet = new HashSet<>();
        for (Book book : bookSet) {
            bookAuthorSet.add(book.getAuthor());
        }

        Set<AuthorDTO> authorDTOList = new HashSet<>();
        for (Set<Author> authorList : bookAuthorSet) {
            for (Author author : authorList) {
                AuthorDTO authorDTO = AuthorDTOTransformer.AUTHOR_DTO_TRANSFORMER.authorToAuthorDTO(author);
                authorDTOList.add(authorDTO);
            }
        }
        return authorDTOList;
    }


    @Override
    public BookDTO saveBook(BookDTO bookDto) {
        Book savedBook = bookRepository.save(BookDTOTransformer.BOOK_DTO_TRANSFORMER.bookDTOToBook(bookDto));
        return BookDTOTransformer.BOOK_DTO_TRANSFORMER.bookToBookDTO(savedBook);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(String.valueOf(id));
    }



    @Override //change getBooksBySectionId
    public List<BookDTO> getBooksBySection(long id) {
        List<Book> bookList = bookRepository.findBySectionId(id);
        log.info(bookList.size()+"");
        return bookList.isEmpty() ? new ArrayList<>() : bookList.stream()
                .map(BookDTOTransformer.BOOK_DTO_TRANSFORMER::bookToBookDTO)
                .collect(Collectors.toList());

    }
}
