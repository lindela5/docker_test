package com.innowise.darya.service;

import com.innowise.darya.entity.Order;
import com.innowise.darya.repositoty.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
        /*if (publisher == null) {
            throw new ThereIsNoSuchBookException();
        }
*/
        return order;
    }
}