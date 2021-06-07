package com.udemy.spring.entities.product;

import com.udemy.spring.entities.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private Double price;
    private String image;
    private Set<Category> categories = new HashSet<>();
}
