package com.qwavee.qwavee_demo.entities;

import java.util.Currency;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity

public class Price {
  @Column(name = "PRICE_LIST")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int priceList;

  @JoinColumn(name = "PRODUCT_ID")
  @ManyToOne
  private Product product;

  @JoinColumn(name = "BRAND_ID")
  @ManyToOne
  private Brand brand;

  @Column(name = "START_DATE")
  private Date startDate;

  @Column(name = "END_DATE")
  private Date endDate;

  @Column(name = "PRIORITY")
  private int priority;

  @Column(name = "PRICE")
  private float price;

  @Column(name = "CURR")
  private Currency curr;

  public Price() {
  }

  public Price(Product product, Date startDate, Date endDate, int priority, Currency curr, float price) {
    this.product = product;
    this.brand = product.getProductBrand();
    this.startDate = startDate;
    this.endDate = endDate;
    this.priority = priority;
    this.curr = curr;
    this.price = price;
  }
}
