package com.udemy.spring.entities.order;

import com.udemy.spring.entities.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    public Order(OrderStatus status, User owner) {
        this.createdAt = LocalDateTime.now();
        this.status = status;
        this.owner = owner;
    }
}
