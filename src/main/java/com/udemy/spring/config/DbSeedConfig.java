package com.udemy.spring.config;

import com.udemy.spring.entities.category.Category;
import com.udemy.spring.entities.category.CategoryRepository;
import com.udemy.spring.entities.order.Order;
import com.udemy.spring.entities.order.OrderRepository;
import com.udemy.spring.entities.order.OrderStatus;
import com.udemy.spring.entities.orderitems.OrderItem;
import com.udemy.spring.entities.orderitems.OrderItemRepository;
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

    @Autowired
    private OrderItemRepository orderItemRepository;

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

        User user1 = new User("Thiago", "thiago@gmail.com", "(16) 9.9999.9988", "123456");
        User user2 = new User("Amanda", "amanda@gmail.com", "(16) 9.9999.9988", "123456");
        User user3 = new User("Theo", "theo@gmail.com", "(16) 9.9999.9988", "123456");
        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Order order1 = new Order(OrderStatus.OPENED, user1);

        orderRepository.save(order1);
        orderItemRepository.saveAll(Arrays.asList(
                new OrderItem(order1, p1, 2, 100.00),
                new OrderItem(order1, p2, 2, 90.00),
                new OrderItem(order1, p3, 1, 550.00)
                ));
    }
}
