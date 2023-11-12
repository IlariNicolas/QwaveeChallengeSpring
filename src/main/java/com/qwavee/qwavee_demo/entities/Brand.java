package com.qwavee.qwavee_demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Brand {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // generate the id of each brand
  private int id;

  @Column(unique = true)
  private String name;

  @Column
  private String description;

  public Brand(String name, String description) {
    this.description = description;
    this.name = name;
  }

  public Brand() {
  }

}
