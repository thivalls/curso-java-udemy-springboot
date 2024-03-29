package com.udemy.spring.config;

import com.udemy.spring.entities.Category;
import com.udemy.spring.entities.Order;
import com.udemy.spring.entities.OrderItem;
import com.udemy.spring.entities.Payment;
import com.udemy.spring.entities.Product;
import com.udemy.spring.entities.User;
import com.udemy.spring.entities.enums.OrderStatus;
import com.udemy.spring.repositories.CategoryRepository;
import com.udemy.spring.repositories.OrderItemRepository;
import com.udemy.spring.repositories.OrderRepository;
import com.udemy.spring.repositories.ProductRepository;
import com.udemy.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Thiago", "thiago@email.com", "991593344", "112233");
        User user2 = new User(null, "Amanda", "amanda@email.com", "991593344", "445566");

        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2019-06-11T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-06-11T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user1);
        Order order3 = new Order(null, Instant.parse("2019-06-11T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order4 = new Order(null, Instant.parse("2019-06-11T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user2);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4));

        Category category1 = new Category(null, "Calçados");
        Category category2 = new Category(null, "Roupas");
        Category category3 = new Category(null, "Vestuário");
        Category category4 = new Category(null, "Monitores");
        Category category5 = new Category(null, "Games");
        Category category6 = new Category(null, "Eletrônicos");

        Product product1 = new Product(null, "Tenis", "Muito confortável", 129.00, "/images/photo.png");
        Product product2 = new Product(null, "Camiseta", "Veste muito bem", 59.90, "/images/photo.png");
        Product product3 = new Product(null, "TV", "Ótima resolução", 999.00, "/images/photo.png");
        Product product4 = new Product(null, "Video Game", "Os jogos mais reais", 2599.00, "/images/photo.png");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3, category4, category5, category6));
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4));

        product1.getCategories().add(category1);
        product1.getCategories().add(category3);

        product2.getCategories().add(category2);
        product2.getCategories().add(category3);

        product3.getCategories().add(category4);
        product3.getCategories().add(category6);

        product4.getCategories().add(category5);
        product4.getCategories().add(category6);

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4));

        OrderItem orderItem1 = new OrderItem(order1, product1, 2, product1.getPrice());
        OrderItem orderItem2 = new OrderItem(order1, product3, 1, product3.getPrice());
        OrderItem orderItem3 = new OrderItem(order2, product3, 2, product3.getPrice());
        OrderItem orderItem4 = new OrderItem(order3, product4, 2, product4.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));

        Payment paymentOrder1 = new Payment(null, Instant.parse("2021-08-15T22:00:00Z"), order1);
        order1.setPayment(paymentOrder1);

        orderRepository.save(order1);


    }
}