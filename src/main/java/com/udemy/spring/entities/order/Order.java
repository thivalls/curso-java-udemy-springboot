package com.udemy.spring.entities.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.spring.entities.orderitems.OrderItem;
import com.udemy.spring.entities.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @JsonIgnore
    public Set<OrderItem> getItems() {
        return items;
    }

    public Order(OrderStatus status, User owner) {
        this.createdAt = LocalDateTime.now();
        this.status = status;
        this.owner = owner;
    }
}
