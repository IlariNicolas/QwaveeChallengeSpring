package com.qwavee.qwavee_demo.entities;

import com.qwavee.qwavee_demo.DTOs.ProductPostDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // uses lombok for getters and setter
@Entity // uses hybernate to persist
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSequence")
  @SequenceGenerator(name = "productSequence", sequenceName = "productSequence", allocationSize = 1, initialValue = 3455)
  private int id;

  @Column
  private String name;

  @Column
  private String description;

  @ManyToOne
  private Brand productBrand;

  public Product(ProductPostDto dto, Brand brand) {
    this.productBrand = brand;
    this.name = dto.getName();
    this.description = dto.getDescription();
  }
}
