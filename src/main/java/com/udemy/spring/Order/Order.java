package com.udemy.spring.Order;

import com.udemy.spring.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant instant;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
