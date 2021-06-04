package com.udemy.spring.config;

import com.udemy.spring.User.User;
import com.udemy.spring.User.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {
        for(int i=0; i < 10; i++) {
            User user = new User("Thiago " + (i+1), "user"+(i+1)+"@gmail.com", "(16) 9.9999.9999", "123456");
            userRepository.save(user);
        }
    }
}
