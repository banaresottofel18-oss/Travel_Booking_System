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
        
    }
    
}
