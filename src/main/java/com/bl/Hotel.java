package com.bl;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private String Name;
    private  double RegularPrice;
    private Map<String, Double> prices;

    private double WeekDayPrice;

    public double getWeekDayPrice() {
        return WeekDayPrice;
    }

    public void setWeekDayPrice(double weekDay) {
        WeekDayPrice = weekDay;
    }

    public double getWeekendDay() {
        return WeekendDayPrice;
    }

    public void setWeekendDay(double weekendDay) {
        WeekendDayPrice = weekendDay;
    }

    private double WeekendDayPrice;
    public Hotel(String Name, double RegularPrice, double weekDay, double weekendDay){
        this.Name = Name;
        this.RegularPrice = RegularPrice;
        this.WeekDayPrice = weekDay;
        this.WeekendDayPrice = weekendDay;
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
