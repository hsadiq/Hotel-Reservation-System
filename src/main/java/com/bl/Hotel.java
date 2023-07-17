package com.bl;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private String name;
    private double regularPrice;
    private Map<String, Double> prices;
    private double weekDayPrice;
    private double weekendDayPrice;
    private int rating;

    public Hotel(String name, double regularPrice, double weekDayPrice, double weekendDayPrice, int rating) {
        this.name = name;
        this.regularPrice = regularPrice;
        this.weekDayPrice = weekDayPrice;
        this.weekendDayPrice = weekendDayPrice;
        this.rating = rating;
        this.prices = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public double getWeekDayPrice() {
        return weekDayPrice;
    }

    public void setWeekDayPrice(double weekDayPrice) {
        this.weekDayPrice = weekDayPrice;
    }

    public double getWeekendDayPrice() {
        return weekendDayPrice;
    }

    public void setWeekendDayPrice(double weekendDayPrice) {
        this.weekendDayPrice = weekendDayPrice;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setPrices(String date, double price) {
        prices.put(date, price);
    }

    public double getPricesForDates(String date) {
        return prices.getOrDefault(date, 0.0);
    }
}
