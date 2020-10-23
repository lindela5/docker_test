package com.innowise.darya.transformer;

import com.innowise.darya.dto.CustomerDTO;
import com.innowise.darya.dto.OrderDTO;
import com.innowise.darya.dto.SupplierDTO;
import com.innowise.darya.entity.Customer;
import com.innowise.darya.entity.Order;
import com.innowise.darya.entity.Supplier;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderDTOTransformerTest {

    static final OrderDTOTransformer ORDER_DTO_TRANSFORMER = Mappers.getMapper(OrderDTOTransformer.class);
    static final Long ID = 1L;
    static final Customer CUSTOMER = new Customer();
        for (Customer customer : ORDER.getCustomer()) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(2L);
        customerDTO.setFirstName("Volga");
        customerDTO.setFirstName("Semencova");
        customerDTO.setAddress("246000, Gomel, Lienin Ave 6/14");
        customerDTO.setPhone("+375336541212");
        customerDTO.setEmail("volga_semencova@mail.ru");
        SUPPLIER.add(supplierDTO);
    }
    static final LocalDate ORDER_DATE = LocalDate.parse("2020-01-14");
    static final BigDecimal AMOUNT = new BigDecimal(213);

    //@formatter=off
    static final OrderDTO ORDER_DTO =
            OrderDTO.builder()
                    .orderId(ID)
                    .customer(CUSTOMER)
                    .orderDate(ORDER_DATE)
                    .amount(AMOUNT)
                    .build();

    static final Order ORDER =
            Order.builder()
                    .orderId(ID)
                    .customer(CUSTOMER)
                    .orderDate(ORDER_DATE)
                    .amount(AMOUNT)
                    .build();
    //@formatter=on

    @Test
    public void shouldReturnOrderDTO() {

        Order order = ORDER_DTO_TRANSFORMER.orderDTOToOrder(ORDER_DTO);

        assertEquals(ORDER_DTO.getOrderId(), order.getOrderId());
        assertEquals(ORDER_DTO.getCustomer(), order.getCustomer());
        assertEquals(ORDER_DTO.getOrderDate(), order.getOrderDate());
        assertEquals(ORDER_DTO.getAmount(), order.getAmount());
    }

    @Test
    public void shouldReturnOrder() {

        OrderDTO orderDto = ORDER_DTO_TRANSFORMER.orderToOrderDTO(ORDER);

        assertEquals(ORDER.getOrderId(), orderDto.getOrderId());
        assertEquals(ORDER_DTO.getCustomer(), orderDto.getCustomer());
        assertEquals(ORDER_DTO.getOrderDate(), orderDto.getOrderDate());
        assertEquals(ORDER_DTO.getAmount(), orderDto.getAmount());
    }
}