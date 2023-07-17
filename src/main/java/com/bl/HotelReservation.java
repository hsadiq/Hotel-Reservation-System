package com.bl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
    private List<Hotel> hotels;

    public HotelReservation() {
        hotels = new ArrayList<>();
    }

    void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public Hotel findCheapestHotel(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("ddMMMyyyy"));
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("ddMMMyyyy"));

        Hotel cheapestHotel = null;
        double cheapestPrice = Double.MAX_VALUE;

        for (Hotel hotel : hotels) {
            double totalPrice = 0.0;
            LocalDate date = start;
            while (!date.isAfter(end)) {
                double price = hotel.getPricesForDates(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                totalPrice += price;
                date = date.plusDays(1);
            }
            if (totalPrice < cheapestPrice) {
                cheapestPrice = totalPrice;
                cheapestHotel = hotel;
            }
        }
        return cheapestHotel;
    }

    public Hotel findBestRatedHotel(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("ddMMMyyyy"));
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("ddMMMyyyy"));

        Hotel bestRatedHotel = null;
        int highestRating = 0;

        for (Hotel hotel : hotels) {
            int rating = hotel.getRating();
            if (rating > highestRating) {
                highestRating = rating;
                bestRatedHotel = hotel;
            } else if (rating == highestRating) {
                double totalPrice = 0.0;
                LocalDate date = start;
                while (!date.isAfter(end)) {
                    double price = hotel.getPricesForDates(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    totalPrice += price;
                    date = date.plusDays(1);
                }
                double currentPrice = 0.0;
                date = start;
                while (!date.isAfter(end)) {
                    double price = bestRatedHotel.getPricesForDates(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    currentPrice += price;
                    date = date.plusDays(1);
                }
                if (totalPrice < currentPrice) {
                    bestRatedHotel = hotel;
                }
            }
        }
        return bestRatedHotel;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");

        HotelReservation reservation = new HotelReservation();

        Hotel hotel1 = new Hotel("Lakewood", 100, 110, 90, 3);
        Hotel hotel2 = new Hotel("BridgeWood", 140, 150, 50, 4);
        Hotel hotel3 = new Hotel("RidgeWood", 200, 220, 150, 5);

        hotel1.setPrices("11-09-2020", 200);
        hotel1.setPrices("12-09-2020", 250);
        hotel2.setPrices("11-09-2020", 300);
        hotel2.setPrices("12-09-2020", 350);
        hotel3.setPrices("11-09-2020", 180);
        hotel3.setPrices("12-09-2020", 200);

        reservation.addHotel(hotel1);
        reservation.addHotel(hotel2);
        reservation.addHotel(hotel3);

        String startDate = "11Sep2020";
        String endDate = "12Sep2020";

        Hotel cheapestHotel = reservation.findCheapestHotel(startDate, endDate);
        Hotel bestRatedHotel = reservation.findBestRatedHotel(startDate, endDate);

        if (cheapestHotel != null) {
            System.out.println("Cheapest Hotel for Date Range: " + startDate + " to " + endDate + " is " +
                    cheapestHotel.getName() + " with Rating: " + cheapestHotel.getRating() +
                    " and Total Rates: $" + cheapestHotel.getTotalPrice(startDate, endDate));
        } else {
            System.out.println("No Hotel Available for Date Range: " + startDate + " to " + endDate);
        }

        if (bestRatedHotel != null) {
            System.out.println("Best Rated Hotel for Date Range: " + startDate + " to " + endDate + " is " +
                    bestRatedHotel.getName() + " with Rating: " + bestRatedHotel.getRating() +
                    " and Total Rates: $" + bestRatedHotel.getTotalPrice(startDate, endDate));
        } else {
            System.out.println("No Hotel Available for Date Range: " + startDate + " to " + endDate);
        }
    }
}
