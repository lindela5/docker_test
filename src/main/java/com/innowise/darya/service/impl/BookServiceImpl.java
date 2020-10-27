package com.innowise.darya.service.impl;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.Author;
import com.innowise.darya.entity.Book;
import com.innowise.darya.repositoty.BookRepository;
import com.innowise.darya.service.BookService;
import com.innowise.darya.transformer.AuthorDTOTransformer;
import com.innowise.darya.transformer.BookDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("bookservice")
public class BookServiceImpl implements BookService  {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getAllBook() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        for (Book book : bookList){
            bookDTOList.add(BookDTOTransformer.BOOK_DTO_TRANSFORMER.bookToBookDTO(book));
        }
        return bookDTOList;
    }

   // @Override
  //  public BookDTO getBookById(long id) {
  //      return null;
 //   }

    @Override
    public BookDTO getBookById(long id) {
        Optional <Book> bookOptional = Optional.ofNullable(bookRepository.findByBookId(id));
        if (!bookOptional.isPresent()){
            return null;
        }
        Book book = bookOptional.get();
        BookDTO bookDTO = BookDTOTransformer.BOOK_DTO_TRANSFORMER.bookToBookDTO(book);
        return bookDTO;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public ResponseEntity<Object> updBook(Book book, long id) {
        return null;
    }

//    @Override
//    public void delBook(long id) {
//        repository.deleteByBookId(id);
//    }

//    @Override
//    public ResponseEntity<Object> updBook(Book book, long id) {
//        Optional<Book> bookOptional = repository.findByBookId(long id);
//        if (!bookOptional.isPresent()){
//            return ResponseEntity.notFound().build();
//        }
//        Book.aBook();
//        repository.save(book);
//        return ResponseEntity.noContent().build();
//    }

    @Override
    public List<AuthorDTO> getAuthorByYearOfIssue(Integer yearOfIssue) {
        List<Book> bookList = bookRepository.findBookByYearOfIssue(yearOfIssue);
        List<Set<Author>> authorList = new ArrayList<>();
        for (Book book : bookList){
            authorList.add(book.getAuthor());
        }

        List<AuthorDTO> authorDTOList = new ArrayList<>();
        for (Set<Author> authorSet : authorList){
            for (Author author : authorSet){
                AuthorDTO authorDTO = AuthorDTOTransformer.AUTHOR_DTO_TRANSFORMER.authorToAuthorDTO(author);
                authorDTOList.add(authorDTO);
            }
        }
        return authorDTOList;
    }

   /* @Override
    public List<String> getBookByYearOfIssue(Integer yearOfIssue) {
        List<Book> bookList = repository.findBookByYearOfIssue(yearOfIssue);
        List<String> albumList = new ArrayList<>();
        for (SongPlayers songPlayers :songPlayersList){
            albumList.add(songPlayers.getAlbum());
        }
        return albumList;
    }

*/

}
