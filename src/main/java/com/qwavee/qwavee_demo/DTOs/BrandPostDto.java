package com.qwavee.qwavee_demo.DTOs;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Valid
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandPostDto {

  @NotNull
  @NotBlank
  private String name;

  @NotNull
  @NotBlank
  private String description;
}