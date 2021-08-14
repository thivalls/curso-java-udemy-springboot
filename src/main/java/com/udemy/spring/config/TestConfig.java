package com.udemy.spring.config;

import com.udemy.spring.entities.Order;
import com.udemy.spring.entities.User;
import com.udemy.spring.entities.enums.OrderStatus;
import com.udemy.spring.repositories.OrderRepository;
import com.udemy.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Thiago", "thiago@email.com", "112233", new ArrayList<>());
        User user2 = new User(null, "Amanda", "amanda@email.com", "445566",new ArrayList<>());

        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2019-06-11T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-06-11T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user1);
        Order order3 = new Order(null, Instant.parse("2019-06-11T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order4 = new Order(null, Instant.parse("2019-06-11T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user2);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4));
    }
}