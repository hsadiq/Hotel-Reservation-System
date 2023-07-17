package com.bl;

public class Hotel {
    private String Name;
    private  double RegularPrice;
    public Hotel(String Name, double RegularPrice){
        this.Name = Name;
        this.RegularPrice = RegularPrice;
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

}
