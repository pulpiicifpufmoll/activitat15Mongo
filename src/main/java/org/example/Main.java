package org.example;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Activitat15 activitat15 = new Activitat15();
        File xmlFile = new File(activitat15.getPathBookingsXml());

        // DESERIALIZACIÓN DEL ARCHIVO XML.
        activitat15.loadBookingsFromXML(xmlFile);

        BookingDAO bookingDAO = new BookingDAO();

        //INSERTAR RESERVA

        Booking booking;

        while (true){
            System.out.println("Dime un identificador de reserva");
            String id = s.nextLine();

            booking = activitat15.getBookingFromList(id);
            if (booking != null){
                break;
            }
        }

        bookingDAO.insertBooking(booking);

        //MOSTRAR RESERVAS

        bookingDAO.showLibros();

        //ACTUALIZAR RESERVA

        while (true) {
            System.out.println("Dime un identificador de reserva para actualizar");
            String id = s.nextLine();

            booking = activitat15.getBookingFromList(id);
            if (booking != null) {
                break;
            }
        }

        int idParsed = Integer.valueOf(booking.getLocation_number());
        double priceParsed = Double.valueOf(booking.getPrice());

        bookingDAO.updateBooking(idParsed, priceParsed);

        //ELIMINAR RESERVA

        while (true) {
            System.out.println("Dime un identificador de reserva para eliminar");
            String id = s.nextLine();

            booking = activitat15.getBookingFromList(id);
            if (booking != null) {
                break;
            }
        }

        idParsed = Integer.valueOf(booking.getLocation_number());

        bookingDAO.deleteBooking(idParsed);
    }
}
