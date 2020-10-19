package com.innowise.darya.repositoty;

import com.innowise.darya.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

    Book findByBookId(Long bookId);

}
