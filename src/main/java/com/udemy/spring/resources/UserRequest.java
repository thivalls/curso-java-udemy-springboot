package com.udemy.spring.resources;

import lombok.Data;
import com.udemy.spring.models.User;

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
