package com.udemy.spring.entities.pk;

import com.udemy.spring.entities.Order;
import com.udemy.spring.entities.Product;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class OrdemItemPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrdemItemPK that = (OrdemItemPK) o;

        if (!Objects.equals(order, that.order)) return false;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(order);
        result = 31 * result + (Objects.hashCode(product));
        return result;
    }
}
