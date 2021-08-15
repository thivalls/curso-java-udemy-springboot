package com.udemy.spring.entities.request;

import com.udemy.spring.entities.User;
import lombok.Data;

@Data
public class UserRequest {
    private final String name;
    private final String email;
    private final String phone;
    private final String password;

    public User toModel() {
        return new User(null, name, email, phone, password);
    }
}
