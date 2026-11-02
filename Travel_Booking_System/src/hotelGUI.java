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
public class hotelGUI extends JFrame implements ActionListener{

    private JLabel hotels, hotelIdLabel, nameLabel, locationLabel, ratingLabel;
    private JComboBox<String> cmbHotelId, cmbName, cmbLocation, cmbRating;
    private JButton btnSearch, btnBookHotel, btnBack;
    private JPanel hotelPanel;
    private DefaultListModel<String> hotelListModel;
    private JList<String> hotelList;

    public hotelGUI(){
        setTitle ("Travel Booking System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        setSize(1000, 1000);

        hotels = new JLabel("Hotels");
        hotels.setBounds(430, 30, 150, 40);
        hotels.setFont(hotels.getFont().deriveFont(25.0f));
        add(hotels);

        hotelIdLabel = new JLabel("Hotel ID:");
        hotelIdLabel.setBounds(80, 110, 65, 25);
        add(hotelIdLabel);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(280, 110, 50, 25);
        add(nameLabel);

        locationLabel = new JLabel("Location:");
        locationLabel.setBounds(515, 110, 65, 25);
        add(locationLabel);

        ratingLabel = new JLabel("Rating:");
        ratingLabel.setBounds(725, 110, 50, 25);
        add(ratingLabel);

        String[] hotelIds = {"", "HT001", "HT002", "HT003", "HT004", "HT005"};
        cmbHotelId = new JComboBox<>(hotelIds);
        cmbHotelId.setBounds(145, 110, 110, 25);
        add(cmbHotelId);

        String[] hotelNames = {"", "Grand Hotel", "City Inn", "Mountain View", "Beach Resort", "Sunset Lounge"};
        cmbName = new JComboBox<>(hotelNames);
        cmbName.setBounds(330, 110, 160, 25);
        add(cmbName);

        String[] locations = {"", "Manila", "Cebu", "Davao", "Boracay", "Palawan"};
        cmbLocation = new JComboBox<>(locations);
        cmbLocation.setBounds(580, 110, 120, 25);
        add(cmbLocation);

        String[] ratings = {"", "1.0", "1.6", "2.0", "2.3", "3.0", "3.7", "4.0", "4.2", "5.0"};
        cmbRating = new JComboBox<>(ratings);
        cmbHotelId.setBounds(775, 110, 90, 25);
        add(cmbRating);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(430, 155, 100, 30);
        btnSearch.addActionListener(this);
        add(btnSearch);

        btnBack = new JButton("Back");
        btnBack.setBounds(20, 20, 80, 30);
        btnBack.addActionListener(this);
        add(btnBack);

        hotelPanel = new JPanel();
        hotelPanel.setBounds(80, 210, 820, 350);

hotelPanel.setBorder(BorderFactory.createTitledBorder("Available Hotels"));
        hotelPanel.setLayout(null);

        JLabel lblHotelId = new JLabel("Hotel ID");
        lblHotelId.setBounds(20, 25, 120, 25);
        hotelPanel.add(lblHotelId);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(170, 25, 200, 25);
        hotelPanel.add(lblName);

        JLabel lblLocation = new JLabel("Location");
        lblLocation.setBounds(430, 25, 150, 25);
        hotelPanel.add(lblLocation);

        JLabel lblRating = new JLabel("Rating");
        lblRating.setBounds(650, 25, 100, 25);
        hotelPanel.add(lblRating);
        
        hotelListModel = new DefaultListModel<>();
        hotelList = new JList<>(hotelListModel);
        JScrollPane scrollPane = new JScrollPane(hotelList);
        scrollPane.setBounds(15, 55, 790, 280);
        hotelPanel.add(scrollPane);
        
        add(hotelPanel);

        btnBookHotel = new JButton("Book Hotel");
        btnBookHotel.setBounds(80, 580, 130, 35);
        btnBookHotel.addActionListener(this);
        add(btnBookHotel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            searchHotels();
        }
        else if (e.getSource() == btnBookHotel) {new hotelGUI().setVisible(true);
            dispose();
        }
        else if (e.getSource() == btnBack) {
            new dashboardGUI().setVisible(true);
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
    
    }
}
        