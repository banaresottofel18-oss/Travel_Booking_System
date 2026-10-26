import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;

public class bookinghistoryGUI extends JFrame implements ActionListener {
 
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
        
        flightModel = new DefaultListModel<>();
        flightList = new JList<>(flightModel);
        
        JScrollPane flightScroll = new JScrollPane(flightList);
        flightScroll.setBounds(10, 25, 250, 460);
        flightPanel.add(flightScroll);
        
        
        hotelModel = new DefaultListModel<>();
        hotelList = new JList<>(hotelModel);
       
        JScrollPane hotelScroll = new JScrollPane(hotelList);
        hotelScroll.setBounds(10, 25, 250, 460);
        hotelPanel.add(hotelScroll);
        
        packageModel = new DefaultListModel<>();
        packageList = new JList<>(packageModel);
        
        JScrollPane packageScroll = new JScrollPane(packageList);
        packageScroll.setBounds(10, 25, 250, 460);
        packagePanel.add(packageScroll);
        
        btnback.addActionListener(this);
        btnview.addActionListener(this);
                
}

    @Override
    public void actionPerformed(ActionEvent e) {
    
            if (e.getSource() == btnback) {
            new dashboardGUI().setVisible(true);
            dispose();
        }

        if (e.getSource() == btnview) {

            String details = "";

            if (flightList.getSelectedValue() != null) {
                details = "Flight: "
                    + flightList.getSelectedValue();
            } else if (hotelList.getSelectedValue() != null) {
                details = "Hotel: "
                    + hotelList.getSelectedValue();
            } else if (packageList.getSelectedValue() != null) {
                details = "Package: "
                    + packageList.getSelectedValue();
            }

            if (details.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please select a booking first."
                );
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    details,
                    "Booking Details",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }
}
