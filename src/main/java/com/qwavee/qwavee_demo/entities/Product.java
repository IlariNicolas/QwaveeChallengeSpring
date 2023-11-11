package com.qwavee.qwavee_demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data // uses lombok for getters and setter
@Entity // uses hybernate to persist

public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // generate the id of each product
  private int id;

  @Column(unique = true)
  private String name;

  @Column
  private String description;

  @ManyToOne
  private Brand productBrand;

  public Product(String name, String description, Brand productBrand) {
    this.name = name;
    this.description = description;
    this.productBrand = productBrand;
  }

  public Product() {
  }
}
