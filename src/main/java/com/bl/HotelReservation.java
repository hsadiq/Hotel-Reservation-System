package com.bl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelReservation {

    private List<Hotel> hotels;
    public HotelReservation(){
        hotels = new ArrayList<>();
    }

    void addHotel(Hotel hotel){
        hotels.add(hotel);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");

        HotelReservation reservation = new HotelReservation();

        Hotel hotel1 = new Hotel("Lakewood", 150);
        Hotel hotel2 = new Hotel("BridgeWood", 200);
        Hotel hotel3 = new Hotel("RidgeWood", 250);

        reservation.addHotel(hotel1);
        reservation.addHotel(hotel2);
        reservation.addHotel(hotel3);

    }
}
