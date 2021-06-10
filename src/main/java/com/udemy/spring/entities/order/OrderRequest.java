package com.udemy.spring.entities.order;

import com.udemy.spring.entities.user.User;
import com.udemy.spring.entities.user.UserRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.Optional;

@Data
public class OrderRequest {
    private OrderStatus status;
    private String owner;

    public Order toOrder(UserRepository userRepository) {
        Optional<User> user = userRepository.findById(Long.parseLong(owner));
        if (user.isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Owner not found");
        return new Order(null, Instant.parse("2021-02-03T20:00:00Z"), OrderStatus.WAITING_PAYMENT, user.get());
    }

    public OrderRequest(String createdAt, OrderStatus status, String owner) {
        this.status = status;
        this.owner = owner;
    }
}
