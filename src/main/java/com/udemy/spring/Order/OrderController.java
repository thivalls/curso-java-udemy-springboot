package com.udemy.spring.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;


    @PersistenceContext
    private EntityManager em;

    @GetMapping
    public ResponseEntity<List<Order>> index() {
        List<Order> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> show(@PathVariable Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not found!");

        return ResponseEntity.ok(order.get());
    }

    @PostMapping
    public ResponseEntity<Order> store(@RequestBody OrderRequest request) {
        Order order = request.toOrder(em);
        orderRepository.save(order);
        return ResponseEntity.ok(order);
    }
}
