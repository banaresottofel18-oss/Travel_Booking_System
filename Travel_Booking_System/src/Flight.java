
import java.time.LocalTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ottofel
 */
public class Flight {
     private String flightId;
    private String departure;
    private String arrival;
    private double price;
    private String date;
    private LocalTime departureTime;

    public Flight(String flightId, String departure, String arrival,
                  double price, String date, LocalTime departureTime) {
        this.flightId = flightId;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.date = date;
        this.departureTime = departureTime;
    }

    public String getFlightId() { return flightId; }
    public String getDeparture() { return departure; }
    public String getArrival() { return arrival; }
    public double getPrice() { return price; }
    public String getDate() { return date; }
    public LocalTime getDepartureTime() { return departureTime; }

    public String getDepartureTimeText() {
        return departureTime == null ? "--:--" : departureTime.toString();
    }

    @Override
    public String toString() {
        return flightId + " " + departure + " -> " + arrival
                + " (" + date + ", " + getDepartureTimeText() + ")";
    }
}

