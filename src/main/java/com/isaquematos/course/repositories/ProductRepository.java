package com.isaquematos.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaquematos.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
