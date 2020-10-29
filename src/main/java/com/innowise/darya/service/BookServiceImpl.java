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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@Slf4j
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;



    @Override
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

    @Override
    public Set<AuthorDTO> getAuthorByYear(Integer year) {
        Set<Book> bookSet = bookRepository.findBookByYearOfIssue(year);
        Set<Set<Author>> bookAuthorSet = new HashSet<>();
        for (Book book : bookSet){
            bookAuthorSet.add(book.getAuthor());
        }

        Set<AuthorDTO> authorDTOList = new HashSet<>();
        for (Set<Author> authorList : bookAuthorSet){
            for (Author author : authorList){
                AuthorDTO authorDTO = AuthorDTOTransformer.AUTHOR_DTO_TRANSFORMER.authorToAuthorDTO(author);
                authorDTOList.add(authorDTO);
            }
        }
        return authorDTOList;
    }

//    @Autowired
//    private JdbcTemplate jtm;
//
//    @Override
//    public List<Book> findAll() {
//        String sql = "SELECT * FROM BOOKS";
//
//       List<Book> book =  jtm.query(sql, new BeanPropertyRowMapper(Book.class));
//
//        return book;
//    }
}
