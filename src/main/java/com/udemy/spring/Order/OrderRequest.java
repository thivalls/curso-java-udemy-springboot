package com.udemy.spring.Order;

import com.udemy.spring.User.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String instant;
    private OrderStatus status;
    private String owner;

    public Order toOrder(EntityManager em) {
        Optional<User> user = Optional.of(em.find(User.class, owner));
        if (user.isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Owner not found");

        return new Order(Instant.parse(instant), OrderStatus.OPENED, user.get());
    }
}
