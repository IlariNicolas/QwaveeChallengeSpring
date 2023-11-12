package com.qwavee.qwavee_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qwavee.qwavee_demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
