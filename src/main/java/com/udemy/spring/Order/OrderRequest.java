package com.udemy.spring.Order;

import com.udemy.spring.User.User;
import com.udemy.spring.User.UserRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Data
public class OrderRequest {
    private OrderStatus status;
    private String owner;

    public Order toOrder(UserRepository userRepository) {
        Optional<User> user = userRepository.findById(Long.parseLong(owner));
        if (user.isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Owner not found");
        return new Order(OrderStatus.OPENED, user.get());
    }

    public OrderRequest(String createdAt, OrderStatus status, String owner) {
        this.status = status;
        this.owner = owner;
    }
}
