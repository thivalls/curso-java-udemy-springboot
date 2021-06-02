package com.udemy.spring.resources;

import lombok.Data;

@Data
public class UserResponse {
    private final String name;
    private final String email;
    private final String phone;
    private final String password;
}
