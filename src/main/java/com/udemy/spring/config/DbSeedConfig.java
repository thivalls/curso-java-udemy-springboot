package com.udemy.spring.config;

import com.udemy.spring.entities.category.Category;
import com.udemy.spring.entities.category.CategoryRepository;
import com.udemy.spring.entities.order.Order;
import com.udemy.spring.entities.order.OrderRepository;
import com.udemy.spring.entities.order.OrderStatus;
import com.udemy.spring.entities.user.User;
import com.udemy.spring.entities.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class DbSeedConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        for (int i = 0; i < 10; i++) {
            User user = new User("Thiago " + (i + 1), "user" + (i + 1) + "@gmail.com", "(16) 9.9999.9988", "123456");
            userRepository.save(user);
            Order order = new Order(OrderStatus.OPENED, user);
            orderRepository.save(order);
        }
    }
}
