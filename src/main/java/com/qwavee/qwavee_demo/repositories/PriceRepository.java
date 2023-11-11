package com.qwavee.qwavee_demo.repositories;

import com.qwavee.qwavee_demo.DTOs.PriceDto;
import com.qwavee.qwavee_demo.entities.Price;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

  @Query("SELECT p.id AS priceList, p.brand.id AS idBrand, p.product.id AS idProduct, p.startDate, p.endDate, CONCAT(p.price, ' ', p.curr) AS finalPrice FROM Product p WHERE (:date BETWEEN p.startDate AND p.endDate) AND (p.product.id = :idProduct) AND (p.brand.id = :idBrand)")
  public PriceDto findfindByDateBrandAndProduct(Date date, int idProduct, int idBrand);

}
