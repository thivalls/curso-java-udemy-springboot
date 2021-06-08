package com.udemy.spring.entities.orderitems;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "order_items")
@Data
public class OrderItems implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderProductPK id;

    private Integer quantity;
    private Double price;

    public Double subTotal() {
        return quantity.doubleValue() * price;
    }
}
