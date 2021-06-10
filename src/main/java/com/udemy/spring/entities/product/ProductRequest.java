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

    public ProductRequest(String name, String description, Double price, String image, Set<Category> categories) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Product toModel() {
        return new Product(null, name, description, price, image);
    }
}
