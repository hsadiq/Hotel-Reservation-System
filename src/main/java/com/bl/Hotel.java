package com.bl;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private String Name;
    private  double RegularPrice;

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    private double Price;

    private Map<String, Double> prices;
    public Hotel(String Name, double RegularPrice, double price){
        this.Name = Name;
        this.Price = price;
        this.RegularPrice = RegularPrice;
        this.prices = new HashMap<>();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getRegularPrice() {
        return RegularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        RegularPrice = regularPrice;
    }

    public void setPrices(String date, double price){
        prices.put(date, price);
    }

    public double getPricesForDates(String date){
        return prices.getOrDefault(date,0.0);
    }
}
