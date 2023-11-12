package com.qwavee.qwavee_demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwavee.qwavee_demo.DTOs.ProductGetDto;
import com.qwavee.qwavee_demo.DTOs.ProductPostDto;
import com.qwavee.qwavee_demo.entities.Brand;
import com.qwavee.qwavee_demo.entities.Product;
import com.qwavee.qwavee_demo.repositories.BrandRepository;
import com.qwavee.qwavee_demo.repositories.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private BrandRepository brandRepostiory;

  public ProductGetDto saveProduct(ProductPostDto product) {
    try {
      Optional<Brand> productBrand = brandRepostiory.findById(product.getIdBrand());
      if (productBrand.isPresent()) {
        Product newProduct = new Product(product, productBrand.get());
        ProductGetDto resultProductDto = new ProductGetDto(this.productRepository.save(newProduct));
        return resultProductDto;
      } else {
        return null;
      }
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }

  }
}
