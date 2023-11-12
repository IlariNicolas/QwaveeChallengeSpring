package com.qwavee.qwavee_demo.DTOs;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceReportDto {
  private int priceList;
  private int idBrand;
  private int idProduct;
  private String startDate;
  private String endDate;
  private String finalPrice;

  public PriceReportDto(int priceList, int idBrand, int idProduct, Date startDate,
      Date endDate, String finalPrice) {
    SimpleDateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    this.priceList = priceList;
    this.idBrand = idBrand;
    this.idProduct = idProduct;

    this.startDate = originalFormat.format(startDate);

    this.endDate = originalFormat.format(endDate);

    this.finalPrice = finalPrice;
  }
}
