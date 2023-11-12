package com.qwavee.qwavee_demo.DTOs;

import com.qwavee.qwavee_demo.entities.Brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BrandGetDto {
  private int id;

  private String name;

  private String description;

  public BrandGetDto(Brand brand) {
    this.id = brand.getId();
    this.name = brand.getName();
    this.description = brand.getDescription();
  }
}
