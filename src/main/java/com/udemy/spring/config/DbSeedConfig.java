package com.udemy.spring.config;

import com.udemy.spring.entities.category.Category;
import com.udemy.spring.entities.category.CategoryRepository;
import com.udemy.spring.entities.order.Order;
import com.udemy.spring.entities.order.OrderRepository;
import com.udemy.spring.entities.order.OrderStatus;
import com.udemy.spring.entities.product.Product;
import com.udemy.spring.entities.product.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        p1.getCategories().add(cat1);
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat1);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        for (int i = 0; i < 10; i++) {
            User user = new User("Thiago " + (i + 1), "user" + (i + 1) + "@gmail.com", "(16) 9.9999.9988", "123456");
            userRepository.save(user);
            Order order = new Order(OrderStatus.OPENED, user);
            orderRepository.save(order);
        }
    }
}
