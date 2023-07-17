package com.bl;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {

    private List<Hotel> hotels;
    public HotelReservation(){
        hotels = new ArrayList<>();
    }

    void addHotel(Hotel hotel){
        hotels.add(hotel);
    }

    public Hotel findCheapestHotel(String date){
        Hotel cheapestHotel = null;
        double cheapestPrice = Double.MAX_VALUE;

        for (Hotel hotel:hotels) {
            double price = hotel.getPricesForDates(date);
            if (price < cheapestPrice){
                cheapestPrice = price;
                cheapestHotel = hotel;
            }
        }
        return cheapestHotel;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");

        HotelReservation reservation = new HotelReservation();

        Hotel hotel1 = new Hotel("Lakewood", 100, 110,90);
        Hotel hotel2 = new Hotel("BridgeWood", 140, 150,50);
        Hotel hotel3 = new Hotel("RidgeWood", 200, 220,150);


        hotel1.setPrices("10-08-2020", 220);
        hotel2.setPrices("11-08-2020", 300);
        hotel3.setPrices("12-08-2020", 400);

        reservation.addHotel(hotel1);
        reservation.addHotel(hotel2);
        reservation.addHotel(hotel3);

        String inputDate = "10-08-2020";

        Hotel cheapestHotel = reservation.findCheapestHotel(inputDate);

        if (cheapestHotel != null){
            System.out.println("Cheapest Hotel for Date: " + inputDate + " is" + "\t" + cheapestHotel.getName());
        }else {
            System.out.println("NO Hotel Available for Date: " + inputDate);
        }

    }
}
