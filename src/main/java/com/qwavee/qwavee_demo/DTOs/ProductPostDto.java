package com.qwavee.qwavee_demo.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Valid
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPostDto {

  @NotNull
  @NotBlank
  private String name;

  @NotNull
  @NotBlank
  private String description;

  @NotNull
  @Min(1)
  private int idBrand;

}
