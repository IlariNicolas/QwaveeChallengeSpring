package com.qwavee.qwavee_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwavee.qwavee_demo.DTOs.BrandGetDto;
import com.qwavee.qwavee_demo.DTOs.BrandPostDto;
import com.qwavee.qwavee_demo.entities.Brand;
import com.qwavee.qwavee_demo.repositories.BrandRepository;

@Service
public class BrandService {
  @Autowired
  private BrandRepository brandRepository;

  public BrandGetDto saveBrand(BrandPostDto brand) {
    try {
      Brand newBrand = new Brand(brand.getName(), brand.getDescription());
      return new BrandGetDto(this.brandRepository.save(newBrand));
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

}
