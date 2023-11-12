package com.qwavee.qwavee_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qwavee.qwavee_demo.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
