package com.innowise.darya.service;

import com.innowise.darya.exception.ThereIsNoSuchOrderException;
import com.innowise.darya.exception.ThereIsNoSuchSupplyException;
import com.innowise.darya.repositoty.OrderRepository;
import com.innowise.darya.repositoty.SupplyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    private static final Long WRONG_ID = 18L;
/*    static final Long BOOK_ID = 1L;
    static final String BOOK_TITLE = "Madol Duwa";
    static final String BOOK_AUTHOR = "Martin Wickramasinghe";
    //@formatter=off

    static final BookEntity BOOK_ENTITY =
            aBookEntity()
                    .id(BOOK_ID)
                    .author(BOOK_AUTHOR)
                    .title(BOOK_TITLE)
                    .build();*/
    //@formatter=on

    @Test
    public void shouldThrowSupplyException() {
        given(orderRepository.findByOrderId(WRONG_ID)).willReturn(null);
        assertThrows(ThereIsNoSuchOrderException.class, () -> orderService.getOrderStats(WRONG_ID));
        then(orderRepository).should(only()).findByOrderId(WRONG_ID);

    }

 /*   @Test
    public void shouldReturnBookStat() {
        given(bookRepository.findById(BOOK_ID)).willReturn(BOOK_ENTITY);
        BookEntity actual = bookService.getBookStats(BOOK_ID);
        assertEquals(BOOK_ENTITY, actual);
        then(bookRepository).should(only()).findById(BOOK_ID);

    }
*/
}