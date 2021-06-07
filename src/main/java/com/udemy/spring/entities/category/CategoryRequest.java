package com.udemy.spring.entities.category;

import lombok.Data;

@Data
public class CategoryRequest {
    private String name;

    public Category toModel() {
        return new Category(null, name);
    }
}
