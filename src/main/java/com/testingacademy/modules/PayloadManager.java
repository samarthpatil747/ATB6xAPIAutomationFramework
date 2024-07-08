package com.testingacademy.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.testingacademy.pojos.*;
import utils.FakerUtil;

public class PayloadManager {
    Gson gson;

    public String createPayloadBookingAsString() {
        Booking booking = new Booking();
        FakerUtil faker = new FakerUtil();
      //  Faker faker = new Faker();
        booking.setFirstname("Samarth");
        booking.setLastname(faker.getLastName());
        booking.setTotalprice(faker.getRandomInt());
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingDates(bookingdates);
        booking.setAdditionalNeeds("Breakfast");
        gson = new Gson();
        String jsonPayload = gson.toJson(booking);
        return jsonPayload;
    }

    public String createInvalidPayloadBookingAsString() {
        return "{}";
    }
    public String fullUpdatePayloadAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Sameer");
        booking.setLastname("Patil");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingDates(bookingdates);
        booking.setAdditionalNeeds("Breakfast");
        return gson.toJson(booking);
    }

    public BookingResponse bookingResponseJava(String responseString){
        gson = new Gson();
        BookingResponse bookingRespons = gson.fromJson(responseString,BookingResponse.class);
        return bookingRespons;
    }

    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println(" Payload set to "+ jsonPayloadString);
        return jsonPayloadString;
    }

    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        // Response ( JSON) ->  Object TokenResponse
        // Deserialization
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse,TokenResponse.class);
        return tokenResponse1.getToken();
    }

    public Booking getResponseFromJSON(String getResponse){
        gson = new Gson();
        // Response ( JSON) ->  Object TokenResponse
        // Deserialization
        Booking booking = gson.fromJson(getResponse,Booking.class);
        return booking;
    }
}
