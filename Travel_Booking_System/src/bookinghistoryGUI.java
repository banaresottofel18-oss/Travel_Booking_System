import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;

public class bookinghistoryGUI extends JFrame {
 
    private JLabel history, flights, hotels, packages;
    private JPanel flightPanel, hotelPanel, packagePanel;
    private JButton btnback, btnview;
    private DefaultListModel<String> flightModel;
    private DefaultListModel<String> hotelModel;
    private DefaultListModel<String> packageModel;
    private JList<String> flightList;
    private JList<String> hotelList;
    private JList<String> packageList;
    
    bookinghistoryGUI(){
        
        setTitle("Travel Booking History");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        
        history = new JLabel ("Booking History");
        history.setBounds(370, 40, 300, 50);
        history.setFont(history.getFont().deriveFont(25.0f));
        add(history);
        
        flights = new JLabel("Flights");
        flights.setBounds(190, 120, 150, 40);
        flights.setFont(flights.getFont().deriveFont(18.0f));
        add(flights);
        
        hotels = new JLabel("Hotels");
        hotels.setBounds(470, 120, 150, 40);
        hotels.setFont(hotels.getFont().deriveFont(18.0f));
        add(hotels);
        
        packages = new JLabel("Packages");
        packages.setBounds(750, 120, 150, 40);
        packages.setFont(packages.getFont().deriveFont(18.0f));
        add(packages);
        
        flightPanel = new JPanel();
        flightPanel.setLayout(null);
        flightPanel.setBounds(50, 165, 270, 500);
        flightPanel.setBorder(BorderFactory.createTitledBorder("Flight Bookings"));
        add(flightPanel);
        
        hotelPanel = new JPanel();
        hotelPanel.setLayout(null);
        hotelPanel.setBounds(330, 165, 270, 500);
        hotelPanel.setBorder(BorderFactory.createTitledBorder("Hotel Bookings"));
        add(hotelPanel);
        
        packagePanel = new JPanel();
        packagePanel.setLayout(null);
        packagePanel.setBounds(610, 165, 270, 500);
        packagePanel.setBorder(BorderFactory.createTitledBorder("Package Bookings"));
        add(packagePanel);
        
        btnback = new JButton("Back");
        btnback.setBounds(50, 40, 90, 35);
        add(btnback);
        
        btnview = new JButton("View");
        btnview.setBounds(700, 720, 150, 40);
        add(btnview);
        
        
                
}
    
