package com.udemy.spring.entities.category;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryRequest {
    private String name;

    public Category toModel() {
        return new Category(null, name);
    }
}
