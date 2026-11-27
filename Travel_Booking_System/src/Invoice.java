/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author espin
 */
public class Invoice {
    
    private Booking booking;

    public Invoice(Booking booking) {
        this.booking = booking;
    }

    public String generateInvoice() {

        String invoice = "";

        invoice += "========== INVOICE ==========\n";
        invoice += "Booking ID: " + booking.getBookingId() + "\n";
        String type = "";
        if (booking.getPackageId() != null && !booking.getPackageId().isEmpty()) {
        type = "Package";
        } else if (booking.getHotelId() != null && !booking.getHotelId().isEmpty()) {
        type = "Hotel";
        } else if (booking.getFlightId() != null && !booking.getFlightId().isEmpty()) {
        type = "Flight";    
           }
        invoice += "Booking Type: " + type + "\n";
        invoice += "User ID: " + booking.getUserId() + "\n";
        invoice += "Description: " + booking.getDescription() + "\n";
        invoice += "Total Price: PHP " + String.format("%,.2f", booking.getTotalPrice()) + "\n";
        invoice += "Booking Date: " + booking.getBookingDate() + "\n";
        invoice += "==============================";

        return invoice;
    }
}
    