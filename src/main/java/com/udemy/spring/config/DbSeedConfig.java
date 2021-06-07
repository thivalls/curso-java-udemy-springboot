package com.udemy.spring.config;

import com.udemy.spring.Order.Order;
import com.udemy.spring.Order.OrderRepository;
import com.udemy.spring.Order.OrderStatus;
import com.udemy.spring.User.User;
import com.udemy.spring.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class DbSeedConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            User user = new User("Thiago " + (i + 1), "user" + (i + 1) + "@gmail.com", "(16) 9.9999.9988", "123456");
            userRepository.save(user);
            Order order = new Order(OrderStatus.OPENED, user);
            orderRepository.save(order);
        }
    }
}
