package com.qwavee.qwavee_demo.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qwavee.qwavee_demo.DTOs.PriceDto;
import com.qwavee.qwavee_demo.services.PriceService;

@RestController
public class PriceController {
  @Autowired
  private PriceService priceService;

  @RequestMapping("api/prices")

  @GetMapping()
  public ResponseEntity<PriceDto> getPriceData(@RequestParam int idProduc, @RequestParam Date date,
      @RequestParam int idBrand) {
    PriceDto result = this.priceService.getPriceData(date, idProduc, idBrand);
    if (result != null) {
      return ResponseEntity.status(HttpStatus.OK).body(result);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
  }
}
