package com.innowise.darya.repositoty;

import com.innowise.darya.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, String> {

    Book findByBookId(Long bookId);


    Set<Book> findBookByYearOfIssue(Integer yearOfIssue);

}
