package com.isaquematos.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaquematos.course.entities.OrderItem;
import com.isaquematos.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
