package com.isaquematos.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaquematos.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
