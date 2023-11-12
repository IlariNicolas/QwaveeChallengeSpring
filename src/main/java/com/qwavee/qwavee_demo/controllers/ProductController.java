package com.qwavee.qwavee_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qwavee.qwavee_demo.DTOs.ProductGetDto;
import com.qwavee.qwavee_demo.DTOs.ProductPostDto;
import com.qwavee.qwavee_demo.services.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
  @Autowired
  private ProductService productService;

  @PostMapping("api/products")
  public ResponseEntity<?> saveProduct(@Valid @RequestBody ProductPostDto product, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("The data provided is not valid, please complete all the fields");
    } else {
      ProductGetDto response = this.productService.saveProduct(product);
      if (response != null) {
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
      } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something wrong happend");
      }
    }
  }
}
