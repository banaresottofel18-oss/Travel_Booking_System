/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author espin
 */
public class Itinerary {
    
     private Booking booking;

    public Itinerary(Booking booking) {
        this.booking = booking;
    }

    public String generateItinerary() {

        String itinerary = "";

        itinerary += "======= TRAVEL ITINERARY =======\n";
        itinerary += "Booking ID: " + booking.getBookingId() + "\n";

        String type = "";

        if (booking.getPackageId() != null && !booking.getPackageId().isEmpty()) {
            type = "Package";
        } else if (booking.getHotelId() != null && !booking.getHotelId().isEmpty()) {
            type = "Hotel";
        } else if (booking.getFlightId() != null && !booking.getFlightId().isEmpty()) {
            type = "Flight";
        }

        itinerary += "Booking Type: " + type + "\n";
        itinerary += "Description: " + booking.getDescription() + "\n";
        itinerary += "Travel Date / Booking Date: " + booking.getBookingDate() + "\n";
        itinerary += "Total Price: PHP " + booking.getTotalPrice() + "\n";
        itinerary += "================================";

        return itinerary;
        
    }
}
