package com.innowise.darya.service;

import com.innowise.darya.entity.Customer;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Customer getCustomerStats(Long customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId);
        if (customer == null) {
            throw new ThereIsNoSuchException("customer");
        }
        return customer;
    }
}
