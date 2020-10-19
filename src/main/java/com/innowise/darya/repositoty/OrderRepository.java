package com.innowise.darya.repositoty;

import com.innowise.darya.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
    Order findByOrderId(Long orderId);
}
