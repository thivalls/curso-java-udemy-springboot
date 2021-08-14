package com.udemy.spring.repositories;

import com.udemy.spring.entities.OrderItem;
import com.udemy.spring.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
