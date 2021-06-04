package com.udemy.spring.Order;

import com.udemy.spring.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date momento;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @OneToMany
    private User owner;
}
