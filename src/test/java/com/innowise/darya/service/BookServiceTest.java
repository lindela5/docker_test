package com.innowise.darya.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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