import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.BorderFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leyco
 */
public class HotelGUI extends JFrame implements ActionListener{

    private JLabel hotels, hotelIdLabel, nameLabel, locationLabel, ratingLabel;
    private JComboBox<String> cmbHotelId, cmbName, cmbLocation, cmbRating;
    private JButton btnSearch, btnBookHotel, btnBack;
    private JPanel hotelPanel;
    private DefaultListModel<String> hotelListModel;
    private JList<String> hotelList;

    public HotelGUI(){
        setTitle ("Travel Booking System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        setSize(1000, 1000);

        hotels = new JLabel("Hotels");
        hotels.setBounds(170, 30, 100, 40);
        hotels.setFont(hotels.getFont().deriveFont(25.0f));
        add(hotels);

        hotelId = new JLabel("Hotel ID:");
        hotelId.setBounds(30, 90, 65, 25);
        add(hotelIdLabel);

        name = new JLabel("Name:");
        name.setBounds(150, 90, 50, 25);
        add(nameLabel);

        location = new JLabel("Location:");
        location.setBounds(260, 90, 65, 25);
        add(locationLabel);

        rating = new JLabel("Rating:");
        rating.setBounds(370, 90, 50, 25);
        add(ratingLabel);

        String[] hotelIds = {"", "HT001", "HT002", "HT003", "HT004", "HT005"};
        cmbHotelId = new JComboBox<>(hotelIds);
        cmbHotelId.setBounds(95, 90, 50, 25);
        add(cmbHotelId);

        String[] hotelNames = {"", "Grand Hotel", "City Inn", "Mountain View", "Beach Resort", "Sunset Lounge"};
        cmbName = new JComboBox<>(hotelNames);
        cmbName.setBounds(205, 90, 50, 25);
        add(cmbName);

        String[] locations = {"", "Manila", "Cebu", "Davao", "Boracay", "Palawan"};
        cmbLocation = new JComboBox<>(locations);
        cmbLocation.setBounds(325, 90, 40, 25);
        add(cmbLocation);

        String[] ratings = {"", "1.0", "1.6", "2.0", "2.3", "3.0", "3.7", "4.0", "4.2", "5.0"};
        cmbRating = new JComboBox<>(ratings);
        cmbHitelId.setBounds(420, 90, 40, 25);
        add(cmbRating);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(355, 125, 80, 25);
        btnSearch.addActionListener(this);
        add(btnSearch);

        btnBack = new JButton("Back");
        btnBack.setBounds(20, 20, 70, 30);
        btnBack.addActionListener(this);
        add(btnBack);

        hotelPanel = new JPanel();
        hotelPanel.setBounds(30, 160, 390, 210);

hotelPanel.setBorder(BorderFactory.createTitledBorder("Available Hotels"));
        hotelPanel.setLayout(null);

        JLabel lblHotelId = new JLabel("Hotel ID");
        lblHotelId.setBounds(10, 5, 70, 20);
        hotelPanel.add(lblHotelId);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(90, 5, 110, 20);
        hotelPanel.add(lblName);

        JLabel lblLocation = new JLabel("Location");
        lblLocation.setBounds(210, 5, 90, 20);
        hotelPanel.add(lblLocation);

        JLabel lblRating = new JLabel("Rating");
        lblRating.setBounds(10, 5, 70, 20);
        hotelPanel.add(lblRating);
        
        hotelListModel = new DefaultListModel<>();
        hotelList = new JList<>(hotelListModel);
        JScrollPane scrollPane = new JScrollPane(hotelList);
        scrollPane.setBounds(10, 30, 370, 170);
        hotelPanel.add(scrollPane);
        
        add(hotelPanel);

        btnBookHotel = new JButton("Book Hotel");
        btnBookHotel.setBounds(30, 385, 130, 30);
        btnBookHotel.addActionListener(this);
        add(btnBookHotel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            searchHotels();
        }
        else if (e.getSource() == btnBookHotel) {           new HotelGUI().setVisible(true);
            dispose();
        }
        else if (e.getSource() == btnBack) {
            dispose();
        }
    }
    
    private void searchHotels() {
        String selectedId = (String) cmbHotelId.getSelectedItem();
        String selectedName = (String) cmbName.getSelectedItem();
        String selectedLoc = (String) cmbLocation.getSelectedItem();
        String selectedRate = (String) cmbRating.getSelectedItem();
        
        hotelListModel.clear();
        
        boolean allEmpty = 
            (selectedId == null || selectedId.isEmpty()) &&
            (selectedName == null || selectedName.isEmpty()) &&
            (selectedLoc == null || selectedLoc.isEmpty()) &&
            (selectedRate == null || selectedRate.isEmpty());

        if (allEmpty) {
            JOptionPane.showMessageDialog(this, "Please select at least one search filter!", "Notice", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Sample hotel data
        String[][] hotelsData = {
            {"HT001", "Grand Hotel", "Manila", "4.5"},
            {"HT002", "Beach Resort", "Cebu", "4.7"},
            {"HT003", "City Inn", "Davao", "4.2"},
            {"HT004", "Mountain View", "Boracay", "4.0"},
            {"HT005", "Sunset Lodge", "Palawan", "5.0"}
        };

        // Filter results based on selections
        for (String[] hotel : hotelsData) {
            boolean match = true;
            if (selectedId != null && !selectedId.isEmpty() && !hotel[0].equals(selectedId)) match = false;
            if (selectedName != null && !selectedName.isEmpty() && !hotel[1].equals(selectedName)) match = false;
            if (selectedLoc != null && !selectedLoc.isEmpty() && !hotel[2].equals(selectedLoc)) match = false;
            if (selectedRate != null && !selectedRate.isEmpty() && !hotel[3].equals(selectedRate)) match = false;

            if (match) {
                hotelListModel.addElement(
                    hotel[0] + "    " + 
                    String.format("%-15s", hotel[1]) + 
                    String.format("%-12s", hotel[2]) + 
                    " ⭐ " + hotel[3]
                );
            }
        }

        if (hotelListModel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hotels match your search criteria.", "No Results", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, hotelListModel.size() + " hotel(s) found!", "Search Results", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Hotel Class
    public class Hotel {
        private String hotelId;
        private String name;
        private String location;
        private double rating;

        public Hotel(String hotelId, String name, String location, double rating) {
            this.hotelId = hotelId;
            this.name = name;
            this.location = location;
            this.rating = rating;
        }

        public String getHotelId() { return hotelId; }
        public String getName() { return name; }
        public String getLocation() { return location; }
        public double getRating() { return rating; }
    }
}

        