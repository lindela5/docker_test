package com.innowise.darya.service;


import com.innowise.darya.entity.BookEntity;
import com.innowise.darya.exception.ThereIsNoSuchBookException;
import com.innowise.darya.repositoty.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.innowise.darya.entity.BookEntity.aBookEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;
/*
@ExtendWith(MockitoExtension.class)
        // добавим к тестовому классу расширение Mockito.
class BookServiceTest {

    @Mock //создаем заглушку (или макет)
    BookRepository bookRepository;

    @InjectMocks //создает экземпляр класса и внедряет @Mock созданные с @Mock (или @Spy) в этот экземпляр
    BookService bookService;

    private static final Long WRONG_ID = 4L;
    static final Long BOOK_ID = 1L;
    static final String BOOK_TITLE = "Madol Duwa";
    static final String BOOK_AUTHOR = "Martin Wickramasinghe";
    //@formatter=off

    static final BookEntity BOOK_ENTITY =
            aBookEntity()
                    .id(BOOK_ID)
                    .author(BOOK_AUTHOR)
                    .title(BOOK_TITLE)
                    .build();
    //@formatter=on

    @Test
    public void shouldThrowException() {
        given(bookRepository.findById(WRONG_ID)).willReturn(null);
        assertThrows(ThereIsNoSuchBookException.class, () -> bookService.getBookStats(WRONG_ID));
        then(bookRepository).should(only()).findById(WRONG_ID);

    }

    @Test
    public void shouldReturnBookStat() {
        given(bookRepository.findById(BOOK_ID)).willReturn(BOOK_ENTITY);
        BookEntity actual = bookService.getBookStats(BOOK_ID);
        assertEquals(BOOK_ENTITY, actual);
        then(bookRepository).should(only()).findById(BOOK_ID);

    }

}*/