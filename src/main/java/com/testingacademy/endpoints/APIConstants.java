package com.testingacademy.endpoints;

import utils.PropertyReader;

public class APIConstants {
    public static String Base_URL ="https://restful-booker.herokuapp.com/";
    public static String Property_URL = PropertyReader.readKey("URL");
    public static String Create_Update_Booking_URL ="/booking";
    public static String Auth_URL = "/auth";
    public static String Ping_URL = "/ping";

}
