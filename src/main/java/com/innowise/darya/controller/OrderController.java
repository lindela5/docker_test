package com.innowise.darya.controller;

import com.innowise.darya.dto.OrderDTO;
import com.innowise.darya.entity.Order;
import com.innowise.darya.service.OrderService;
import com.innowise.darya.transformer.OrderDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)


    public ResponseEntity<OrderDTO> getOrderStats(@PathVariable final Long orderId) {
        Order order = orderService.getOrderStats(orderId);
        OrderDTO orderDTO = OrderDTOTransformer.ORDER_DTO_TRANSFORMER.orderToOrderDTO(order);
        return ResponseEntity.ok(orderDTO);
    }
}
