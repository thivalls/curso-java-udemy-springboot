package com.udemy.spring.User;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String phone;
    private String password;

    public User toModel() {
        return new User(null, name, email, phone, password);
    }
}
