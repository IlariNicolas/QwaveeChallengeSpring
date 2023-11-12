package com.qwavee.qwavee_demo.DTOs;

import java.sql.Date;

import lombok.Data;

@Data
public class PriceGetDto {
  private int priceList;
  private int idBrand;
  private int idProduct;
  private String startDate;
  private String endDate;
  private String finalPrice;

  public PriceGetDto() {
  }

  public PriceGetDto(int priceList, int idBrand, int idProduct, String startDate, String endDate, String finalPrice) {
    this.priceList = priceList;
    this.idBrand = idBrand;
    this.idProduct = idProduct;
    this.startDate = startDate;
    this.endDate = endDate;
    this.finalPrice = finalPrice;
  }
}
