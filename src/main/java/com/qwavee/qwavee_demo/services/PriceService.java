package com.qwavee.qwavee_demo.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwavee.qwavee_demo.DTOs.PriceGetDto;
import com.qwavee.qwavee_demo.DTOs.PricePostDto;
import com.qwavee.qwavee_demo.DTOs.PriceReportDto;
import com.qwavee.qwavee_demo.entities.Price;
import com.qwavee.qwavee_demo.entities.Product;
import com.qwavee.qwavee_demo.repositories.PriceRepository;
import com.qwavee.qwavee_demo.repositories.ProductRepository;

@Service
public class PriceService {

  private final SimpleDateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

  private final SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

  @Autowired
  private PriceRepository priceRepository;

  @Autowired
  private ProductRepository productRepository;

  private PriceReportDto transformDto(Price price) {
    return new PriceReportDto(price.getPriceList(), price.getBrand().getId(), price.getProduct().getId(),
        newFormat.format(price.getStartDate()), newFormat.format(price.getEndDate()),
        price.getPrice() + " " + price.getCurr());
  }

  public PriceReportDto getPriceData(String date, int idProd, int idBrand) {
    try {
      java.util.Date sqlDate = originalFormat.parse(date);
      Price result = this.priceRepository.findPriceByDateBrandAndProduct(sqlDate, idProd, idBrand);

      if (result != null) {
        return this.transformDto(result);
      } else {
        return null;
      }
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }

  }

  public PriceGetDto savePrice(PricePostDto dtoPrice) {
    try {
      java.util.Date startDateParse = originalFormat.parse(dtoPrice.getStartDate());
      java.util.Date endDateParse = originalFormat.parse(dtoPrice.getEndDate());
      Optional<Product> savedProduct = productRepository.findById(dtoPrice.getProductId());
      if (savedProduct.isPresent()) {
        Product product = savedProduct.get();
        if (product.getProductBrand().getId() == dtoPrice.getBrandId()) {
          Price price = new Price(product, startDateParse, endDateParse, dtoPrice.getPriority(), dtoPrice.getCurr(),
              dtoPrice.getPrice());
          price = this.priceRepository.save(price);

          String formatStartDate = newFormat.format(startDateParse);
          String formatEndDate = newFormat.format(endDateParse);
          PriceGetDto returnDto = new PriceGetDto(price.getPriceList(), price.getBrand().getId(),
              price.getProduct().getId(), formatStartDate, formatEndDate, price.getPrice() + " " + price.getCurr());
          return returnDto;
        } else {
          System.out.println("product brand id and brand id missmatch");
          return null;
        }
      } else {
        System.out.println("Wanted product is not present");
        return null;
      }
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
}
