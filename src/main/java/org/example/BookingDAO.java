package org.example;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;


public class BookingDAO {
    private MongoCollection<Document> collection;
    public BookingDAO() {
        this.collection = new MongoDBConnector().getDatabase().getCollection("bookings");
    }

    public void insertBooking(Booking booking) {
        Document bookingToInsert = new Document("location_number", booking.getLocation_number())
                .append("price", booking.getPrice())
                .append("room_nights", booking.getRoom_nights())
                .append("client", booking.getClient())
                .append("agency", booking.getAgency())
                .append("room", booking.getRoom())
                .append("hotel", booking.getHotel())
                .append("check_in", booking.getCheck_in());

        collection.insertOne(bookingToInsert);
        System.out.println("Reserva insertada correctamente.");
    }

    public void showLibros() {
        MongoCursor<Document> cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next().toJson());
        }
    }

    public void updateBooking(int location_number, double price) {
        collection.updateOne(Filters.eq("location_number", location_number), Updates.set("price", price));
        System.out.println("Reserva actualizado correctamente.");
    }

    public void deleteBooking(int location_number) {
        collection.deleteOne(Filters.eq("location_number", location_number));
        System.out.println("Reserva eliminado correctamente.");
    }

}
