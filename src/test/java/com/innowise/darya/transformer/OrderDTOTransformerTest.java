package com.innowise.darya.transformer;

import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.dto.CustomerDTO;
import com.innowise.darya.dto.OrderDTO;
import com.innowise.darya.dto.SupplierDTO;
import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Customer;
import com.innowise.darya.entity.Order;
import com.innowise.darya.entity.Supplier;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderDTOTransformerTest {

    static final OrderDTOTransformer ORDER_DTO_TRANSFORMER = Mappers.getMapper(OrderDTOTransformer.class);
    static final Long ID = 1L;
    static final Set<Book> BOOK_ORDER = Set.of(
            Book.aBook().bookId(2L).price(TEN).build(),
            Book.aBook().bookId(3L).price(TEN).build());
    static final Set<BookDTO> BOOK_ORDER_DTO = Set.of(
            BookDTO.builder().bookId(2L).price(TEN).build(),
            BookDTO.builder().bookId(3L).price(TEN).build());


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
    static final OrderDTO ORDER_DTO =
            OrderDTO.builder()
                    .orderId(ID)
                    .bookOrder(BOOK_ORDER_DTO)
                    .customer(CUSTOMER)
                    .orderDate(ORDER_DATE)
                    .amount(AMOUNT)
                    .build();

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
    public void shouldReturnOrderDTO() {

        Order order = ORDER_DTO_TRANSFORMER.orderDTOToOrder(ORDER_DTO);

        assertEquals(ORDER_DTO.getOrderId(), order.getOrderId());
        assertEquals(ORDER_DTO.getBookOrder(), order.getBookOrder());
        assertEquals(ORDER_DTO.getCustomer(), order.getCustomer());
        assertEquals(ORDER_DTO.getOrderDate(), order.getOrderDate());
        assertEquals(ORDER_DTO.getAmount(), order.getAmount());
    }

    @Test
    public void shouldReturnOrder() {

        OrderDTO orderDto = ORDER_DTO_TRANSFORMER.orderToOrderDTO(ORDER);

        assertEquals(ORDER.getOrderId(), orderDto.getOrderId());
        assertEquals(ORDER.getBookOrder(), orderDto.getBookOrder());
        assertEquals(ORDER.getCustomer(), orderDto.getCustomer());
        assertEquals(ORDER.getOrderDate(), orderDto.getOrderDate());
        assertEquals(ORDER.getAmount(), orderDto.getAmount());
    }
}