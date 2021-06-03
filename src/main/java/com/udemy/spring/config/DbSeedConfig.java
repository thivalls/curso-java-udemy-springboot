package com.udemy.spring.config;

import com.udemy.spring.User.User;
import com.udemy.spring.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class DbSeedConfig implements Runnable {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run() {
        String[] names = new String[] { "Thiago", "Amanda", "Theo" };
        String[] emails = new String[] { "thiago@teste.com", "amanda@teste.com", "theo@teste.com" };

        List<User> users = new ArrayList<>();

        for(int i = 0; i <= names.length; i++) {
            System.out.println(i);
        }

        User u1 = new User(null, "Thiago", "user@gmail.com", "(16) 9.9999.9999", "123456");
    }
}
