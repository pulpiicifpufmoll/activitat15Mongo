package org.example;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Activitat15 {
    private final String pathBookingsXml = "src/main/resources/bookings.xml";
    private List<Booking> bookings;

    public void loadBookingsFromXML(File file){
        try{
            XmlMapper xmlMapper = new XmlMapper();
            bookings = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, Booking.class));

            for (Booking booking : bookings) {
                System.out.println(booking);
            }
            // Convert Java objects to JSON
           // String jsonResult = xmlMapper.writeValueAsString(bookings);

            //System.out.println(jsonResult);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Booking getBookingFromList(String location_number){
        Optional<Booking> b = bookings.stream()
                .filter(booking -> booking.getLocation_number().equals(location_number))
                .findFirst();

        if (b.isPresent()){
            System.out.println("Reserva encontrada con identificador: " + b.get().getLocation_number());
        } else {
            System.err.println("Reserva no encotrada con ese identificador");
            return null;
        }

        return b.get();

    }

    public String getPathBookingsXml() {
        return pathBookingsXml;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}