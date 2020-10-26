package com.innowise.darya.service;

import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Customer;
import com.innowise.darya.entity.Order;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.OrderRepository;
import com.innowise.darya.repositoty.SupplyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static java.math.BigDecimal.TEN;
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
    static final Long ID = 1L;
    static final Set<Book> BOOK_ORDER = Set.of(
            Book.aBook().bookId(2L).price(TEN).build(),
            Book.aBook().bookId(3L).price(TEN).build());

    static final Customer CUSTOMER = Customer.builder()
            .customerId(2L)
            .firstName("Volga")
            .lastName("Semencova")
            .address("246000, Gomel, Lienin Ave 6/14")
            .phone("+375336541212")
            .email("volga_semencova@mail.ru")
            .build();

    static final LocalDate ORDER_DATE = LocalDate.parse("2020-01-14");
    static final BigDecimal AMOUNT = new BigDecimal(213);

    //@formatter=off
    static final Order ORDER =
            Order.builder()
                    .orderId(ID)
                    .bookOrder(BOOK_ORDER)
                    .customer(CUSTOMER)
                    .orderDate(ORDER_DATE)
                    .amount(AMOUNT)
                    .build();
    //@formatter=on

    @Test
    public void shouldThrowSupplyException() {
        given(orderRepository.findByOrderId(WRONG_ID)).willReturn(null);
        assertThrows(ThereIsNoSuchException.class, () -> orderService.getOrderStats(WRONG_ID));
        then(orderRepository).should(only()).findByOrderId(WRONG_ID);

    }

    @Test
    public void shouldReturnBookStat() {
        given(orderRepository.findByOrderId(ID)).willReturn(ORDER);
        Order actual = orderService.getOrderStats(ID);
        assertEquals(ORDER, actual);
        then(orderRepository).should(only()).findByOrderId(ID);

    }

}