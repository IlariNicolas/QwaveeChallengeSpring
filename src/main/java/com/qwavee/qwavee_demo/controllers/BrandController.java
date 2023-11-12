package com.qwavee.qwavee_demo.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qwavee.qwavee_demo.DTOs.BrandGetDto;
import com.qwavee.qwavee_demo.DTOs.BrandPostDto;
import com.qwavee.qwavee_demo.entities.Brand;
import com.qwavee.qwavee_demo.services.BrandService;

import jakarta.validation.Valid;

@RestController
public class BrandController {

  @Autowired
  private BrandService brandService;

  @PostMapping("/api/brands")
  public ResponseEntity<?> saveBrand(@Valid @RequestBody BrandPostDto brand, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("The data provided is not valid, please complete all the fields");
    } else {
      BrandGetDto response = this.brandService.saveBrand(brand);
      if (response != null) {
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
      } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something wrong happend");
      }
    }
  }
}
