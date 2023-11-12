package com.qwavee.qwavee_demo.DTOs;

import com.qwavee.qwavee_demo.entities.Brand;
import com.qwavee.qwavee_demo.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductGetDto {
  private int id;

  private String name;

  private String description;

  private Brand brand;

  public ProductGetDto(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.description = product.getDescription();
    this.brand = product.getProductBrand();
  }
}
