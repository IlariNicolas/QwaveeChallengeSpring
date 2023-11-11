package com.qwavee.qwavee_demo.DTOs;

import java.sql.Date;

import lombok.Data;

@Data
public class PriceDto {
  private int priceList;
  private int idBrand;
  private int idProduct;
  private Date startDate;
  private Date endDate;
  private String finalPrice;

  public PriceDto() {
  }

  public PriceDto(int priceList, int idBrand, int idProduct, Date startDate, Date endDate, String finalPrice) {
    this.priceList = priceList;
    this.idBrand = idBrand;
    this.idProduct = idProduct;
    this.startDate = startDate;
    this.endDate = endDate;
    this.finalPrice = finalPrice;
  }
}
