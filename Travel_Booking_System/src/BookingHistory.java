/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author espin
 */

import java.sql.*;
import java.util.ArrayList;

public class BookingHistory {
    
   public ArrayList<Booking> getBookings(String userId) {

        ArrayList<Booking> bookings = new ArrayList<>();

        String sql = "SELECT booking_id, user_id, flight_id, "
                + "hotel_id, package_id, total_price, "
                + "description, booking_date "
                + "FROM bookings WHERE user_id = ? "
                + "ORDER BY booking_date DESC";

        try (Connection conn = MysqlConnect.ConnectDB()) {

            if (conn == null) {
                return bookings;
            }

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, userId);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Booking booking = new Booking(
                        rs.getInt("booking_id"),
                        rs.getString("user_id"),
                        rs.getString("flight_id"),
                        rs.getString("hotel_id"),
                        rs.getString("package_id"),
                        rs.getDouble("total_price"),
                        rs.getString("description"),
                        rs.getString("booking_date")
                );

                bookings.add(booking);
            }

            rs.close();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }
}
