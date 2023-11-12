package com.qwavee.qwavee_demo.DTOs;

import java.util.Currency;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Valid
public class PricePostDto {
  @NotNull
  @Min(1)
  private int brandId;

  @NotNull
  @Min(1)
  private int productId;

  @NotNull
  @Min(0)
  private int priority;

  @NotNull
  @Pattern(regexp = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(\\d{4}) (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$", message = "not a valid format please use MM/dd/yyyy HH:mm:ss")
  private String startDate;

  @NotNull
  @Pattern(regexp = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(\\d{4}) (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$", message = "not a valid format please use MM/dd/yyyy HH:mm:ss")
  private String endDate;

  @NotNull
  @Min(0)
  private float price;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Currency curr;
}
