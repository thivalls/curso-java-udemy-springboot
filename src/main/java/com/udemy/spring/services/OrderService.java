package com.udemy.spring.services;

import com.udemy.spring.entities.Order;
import com.udemy.spring.repositories.OrderRepository;
import com.udemy.spring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }


    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
