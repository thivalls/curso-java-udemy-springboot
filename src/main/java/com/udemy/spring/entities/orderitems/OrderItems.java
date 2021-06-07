package com.udemy.spring.entities.orderitems;

import com.udemy.spring.entities.product.Product;

import javax.persistence.Entity;
import javax.persistence.Table;

// @Entity
// @Table(name = "order_items")
public class OrderItems {
    private Integer quantity;
    private Product product;

    public Double subTotal() {
        return quantity.doubleValue() * product.getPrice();
    }
}
