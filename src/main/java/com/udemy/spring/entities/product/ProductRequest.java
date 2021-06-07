package com.udemy.spring.entities.product;

import com.udemy.spring.entities.category.Category;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private String image;
    private Set<Category> categories = new HashSet<>();

    public Product toModel() {
        return new Product(name, description, price, image, categories);
    }
}
