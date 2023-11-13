package com.qwavee.qwavee_demo.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qwavee.qwavee_demo.DTOs.PriceGetDto;
import com.qwavee.qwavee_demo.DTOs.PricePostDto;
import com.qwavee.qwavee_demo.DTOs.PriceReportDto;
import com.qwavee.qwavee_demo.services.PriceService;

import jakarta.validation.Valid;

@RestController
public class PriceController {
  @Autowired
  private PriceService priceService;

  @GetMapping("api/prices")
  public ResponseEntity<?> getPriceData(@RequestParam int idProduc, @RequestParam String date,
      @RequestParam int idBrand) {
    PriceReportDto result = this.priceService.getPriceData(date, idProduc, idBrand);
    if (result != null) {
      return ResponseEntity.status(HttpStatus.OK).body(result);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
    }
  }

  @PostMapping("api/prices")
  public ResponseEntity<?> savePrice(@Valid @RequestBody PricePostDto price, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please check the format");
    } else {
      PriceGetDto result = this.priceService.savePrice(price);
      if (result != null) {
        return ResponseEntity.status(HttpStatus.CREATED).body(price);
      } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
      }
    }
  }
}
