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

    private JLabel hotels, hotelId, name, location, rating;
    private JTextField txtHotelId, txtName, txtLocation, txtRating;
    private JButton btnSearch, btnBook, btnBack;
    private JPanel hotelPanel;
    private DefaultListModel<String> hotelListModel;
    private JList<String> hotelList;

    public HotelGUI(){
        setTitle ("Travel Booking System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);

        hotels = new JLabel("Hotels");
        hotels.setBounds(170, 30, 100, 40);
        hotels.setFont(hotels.getFont().deriveFont(25.0f));
        add(hotels);

        hotelId = new JLabel("Hotel ID:");
        hotelId.setBounds(30, 100, 70, 25);
        add(hotelId);

        name = new JLabel("Name:");
        name.setBounds(130, 100, 50, 25);
        add(name);

        location = new JLabel("Location:");
        location.setBounds(230, 100, 65, 25);
        add(location);

        rating = new JLabel("Rating:");
        rating.setBounds(330, 100, 50, 25);
        add(rating);

        txtHotelId = new JTextField();
        txtHotelId.setBounds(90, 100, 35, 25);
        add(txtHotelId);

        txtName = new JTextField();
        txtName.setBounds(180, 100, 45, 25);
        add(txtName);

        txtLocation = new JTextField();
        txtLocation.setBounds(290, 100, 35, 25);
        add(txtLocation);

        txtRating = new JTextField();
        txtRating.setBounds(375, 100, 40, 25);
        add(txtRating);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(325, 135, 90, 25);
        btnSearch.addActionListener(this);
        add(btnSearch);

        btnBook = new JButton("Book");
        btnBook.setBounds(325, 375, 70, 30);
        btnBook.addActionListener(this);
        add(btnBook);

        btnBack = new JButton("Back");
        btnBack.setBounds(20, 20, 70, 30);
        btnBack.addActionListener(this);
        add(btnBack);

        hotelPanel = new JPanel();
        hotelPanel.setBounds(30, 170, 365, 190);

hotelPanel.setBorder(BorderFactory.createTitledBorder("Available Hotels"));
        hotelPanel.setLayout(null);
        
        hotelListModel = new DefaultListModel<>();
        hotelList = new JList<>(hotelListModel);
        JScrollPane scrollPane = new JScrollPane(hotelList);
        scrollPane.setBounds(10, 20, 345, 160);
        hotelPanel.add(scrollPane);
        
        add(hotelPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            searchHotels();
        }
        else if (e.getSource() == btnBook) {
            bookHotel();
        }
        else if (e.getSource() == btnBack) {
            dispose();
        }
    }
    
    private void searchHotels() {
        String id = txtHotelId.getText().trim();
        String hotelName = txtName.getText().trim();
        String loc = txtLocation.getText().trim();
        String rateText = txtRating.getText().trim();
        
        hotelListModel.clear();
        
        if (id.isEmpty() && hotelName.isEmpty() && loc.isEmpty() && rateText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter at least one search field!", "Notice", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        StringBuilder result = new StringBuilder();
        if (!id.isEmpty()) result.append("ID: ").append(id).append(" ");
        if (!hotelName.isEmpty()) result.append("Name: ").append(hotelName).append(" ");
        if (!loc.isEmpty()) result.append("Location: ").append(loc).append(" ");
        if (!rateText.isEmpty()) result.append("Rating: ").append(rateText);
        
        hotelListModel.addElement(result.toString());
        JOptionPane.showMessageDialog(this, "Search completed!", "Search", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void bookHotel() {
        String selected = hotelList.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Please search and select a hotel first!", "No Selection made", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Hotel booked successfully!\n\n" + selected, "Booking Confirmed", JOptionPane.INFORMATION_MESSAGE);
        hotelListModel.clear();
        txtHotelId.setText("");
        txtName.setText("");
        txtLocation.setText("");
        txtRating.setText("");
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

        