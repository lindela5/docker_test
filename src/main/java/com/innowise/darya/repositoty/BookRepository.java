package com.innowise.darya.repositoty;

import com.innowise.darya.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<BookEntity,String> {

    BookEntity findById(Long id);

}
