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
 * @author espin
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
        