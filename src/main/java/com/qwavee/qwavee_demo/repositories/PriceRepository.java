package com.qwavee.qwavee_demo.repositories;

import com.qwavee.qwavee_demo.DTOs.PriceGetDto;
import com.qwavee.qwavee_demo.DTOs.PriceReportDto;
import com.qwavee.qwavee_demo.entities.Price;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    /*
     * @Query("SELECT p.id AS priceList, p.brand.id AS idBrand, p.product.id AS idProduct, p.startDate, p.endDate, CONCAT(p.price, ' ', p.curr) AS finalPrice FROM Price p WHERE (:date BETWEEN p.startDate AND p.endDate) AND (p.product.id = :idProduct) AND (p.brand.id = :idBrand) ORDER BY p.priority DESC LIMIT 1"
     * )
     * public PriceReportDto findPriceByDateBrandAndProduct(@Param("date") Date
     * date, @Param("idProduct") int idProduct,
     * 
     * @Param("idBrand") int idBrand);
     */
    @Query("SELECT p FROM Price p WHERE (:date BETWEEN p.startDate AND p.endDate) AND (p.product.id = :idProduct) AND (p.brand.id = :idBrand) ORDER BY p.priority DESC LIMIT 1")
    public Price findPriceByDateBrandAndProduct(@Param("date") Date date, @Param("idProduct") int idProduct,
            @Param("idBrand") int idBrand);

}
