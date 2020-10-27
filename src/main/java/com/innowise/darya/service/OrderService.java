package com.innowise.darya.service;

import com.innowise.darya.entity.Author;
import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Order;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public Order getOrderStats(Long orderId) {

      Order order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            throw new ThereIsNoSuchException();
        }
        return order;
    }
}
