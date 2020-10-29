package com.innowise.darya.service;

import com.innowise.darya.entity.Order;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order getOrderStats(Long orderId) {

        Order order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            throw new ThereIsNoSuchException("order");
        }
        return order;
    }
}
