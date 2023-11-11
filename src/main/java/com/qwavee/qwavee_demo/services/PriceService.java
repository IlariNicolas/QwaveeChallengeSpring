package com.qwavee.qwavee_demo.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwavee.qwavee_demo.DTOs.PriceDto;
import com.qwavee.qwavee_demo.repositories.PriceRepository;

@Service
public class PriceService {
  @Autowired
  private PriceRepository priceRepository;

  public PriceDto getPriceData(Date date, int idProd, int idBrand) {
    PriceDto result = this.priceRepository.findfindByDateBrandAndProduct(date, idProd, idBrand);
    return result;
  }
}
