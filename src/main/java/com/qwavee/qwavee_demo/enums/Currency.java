package com.qwavee.qwavee_demo.enums;

public enum Currency {
  USD("Dólar estadounidense"),
  EUR("Euro"),
  JPY("Yen japonés"),
  GBP("Libra esterlina"),
  AUD("Dólar australiano"),
  CAD("Dólar canadiense"),
  CNY("Yuan chino"),
  INR("Rupia india"),
  BRL("Real brasileño"),
  MXN("Peso mexicano"),
  CHF("Franco suizo"),
  SEK("Corona sueca"),
  NZD("Dólar neozelandés"),
  SGD("Dólar singapurense"),
  KRW("Won surcoreano"),
  ARS("Peso argentino");

  private String description;

  Currency(String description) {
    this.description = description;
  }

  public String getDesciption() {
    return description;
  }
}
