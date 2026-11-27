/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ottofel
 */
public class Booking {
     private int bookingId;       
    private String userId;
    private String flightId; 
    private String hotelId;
    private String packageId;
    private double totalPrice;
    private String description;
    private String bookingDate;   

    public Booking(int bookingId, String userId, String flightId, String hotelId,
                   String packageId, double totalPrice, String description,
                   String bookingDate) {
        
        this.bookingId = bookingId;
        this.userId = userId;
        this.flightId = flightId;
        this.hotelId = hotelId;
        this.packageId = packageId;
        this.totalPrice = totalPrice;
        this.description = description;
        this.bookingDate = bookingDate;
    }
    
        public Booking(int bookingId, String userId, String flightId,
            String packageId, double totalPrice, String description,
            String bookingDate) {
        
        this(bookingId, userId, flightId, null, packageId,
                totalPrice, description, bookingDate);
    
    }
    public Booking(String userId, String flightId, String hotelId,
            String packageId, double totalPrice, String description) {
        this(0, userId, flightId, hotelId, packageId,
                totalPrice, description, null);
    }

    public Booking(String userId, String flightId,
            double totalPrice, String description) {
        
        this(0, userId, flightId, null, null,
                totalPrice, description, null);
    }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }
    
    public String getUserId() { return userId; }
    public String getFlightId() { return flightId; }
    public String getHotelId() { return hotelId; }
    public String getPackageId() { return packageId; }
    public double getTotalPrice() { return totalPrice; }
    public String getDescription() { return description; }
    public String getBookingDate() { return bookingDate; }
    
    public String getType() {
    if (packageId != null && !packageId.isEmpty()) {
        return "Package";
    } else if (hotelId != null && !hotelId.isEmpty()) {
        return "Hotel";
    } else if (flightId != null && !flightId.isEmpty()) {
        return "Flight";
    }
    return "Unknown";
}

    @Override
    public String toString() {
        return "#" + bookingId + "  " + description;
    }
}

