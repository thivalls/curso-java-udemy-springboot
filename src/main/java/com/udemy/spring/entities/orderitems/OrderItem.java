package com.udemy.spring.entities.orderitems;

import com.udemy.spring.entities.order.Order;
import com.udemy.spring.entities.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "order_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderProductPK id = new OrderProductPK();

    private Integer quantity;
    private Double price;

    public Double subTotal() {
        return quantity.doubleValue() * price;
    }

    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(id.getOrder());
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(id.getProduct());
    }

    public void setId(OrderProductPK id) {
        this.id = id;
    }
}
