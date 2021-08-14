package com.udemy.spring.config;

import com.udemy.spring.entities.User;
import com.udemy.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(1L, "Thiago", "thiago@email.com", "112233");
        User user2 = new User(2L, "Amanda", "amanda@email.com", "445566");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}