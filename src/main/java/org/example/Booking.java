package org.example;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Booking {
    @JacksonXmlProperty(isAttribute = true, localName = "location_number")
    private String location_number;
    private String price;
    private String room_nights;
    private String client;
    private String agency;
    private String room;
    private String hotel;
    private String check_in;


    public Booking() {
    }

    @Override
    public String toString() {
        return "Booking{" +
                "location_number='" + location_number + '\'' +
                ", price='" + price + '\'' +
                ", room_nights='" + room_nights + '\'' +
                ", client='" + client + '\'' +
                ", agency='" + agency + '\'' +
                ", room='" + room + '\'' +
                ", hotel='" + hotel + '\'' +
                ", check_in='" + check_in + '\'' +
                '}';
    }

    public String getLocation_number() {
        return location_number;
    }

    public void setLocation_number(String location_number) {
        this.location_number = location_number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRoom_nights() {
        return room_nights;
    }

    public void setRoom_nights(String room_nights) {
        this.room_nights = room_nights;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }
}
