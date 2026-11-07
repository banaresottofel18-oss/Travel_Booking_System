import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Time;
import java.time.LocalTime;
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author espin
 */
public class flightsGUI extends JFrame implements ActionListener{
    
    private JLabel flights, from, to, date;
    private JTextField txtdate;
    private JButton btnsearch, btnbook, btnback;
    private JComboBox<String> toBox,fromBox,dateBox;
    private DefaultTableModel Model;
    private JTable Table;
    private JScrollPane Scroll;
    private String user ;
    private LinkedList<Flight> show = new LinkedList<>();
   
   



    flightsGUI(){
        
        
      
        setTitle ("Travel Booking System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        
        flights = new JLabel(" Book your Flights!");
        flights.setBounds(350, 40, 300, 50);
        flights.setFont(flights.getFont().deriveFont(25.0f));
        add(flights);
    
        from = new JLabel("From:");
        from.setBounds(50, 150, 50, 30);
        add(from);
        
        to = new JLabel("To:");
        to.setBounds(300, 150, 40, 30);
        add(to);
        
        date = new JLabel("Date:");
        date.setBounds(540, 150, 50, 30);
        add(date);
 
        fromBox = new JComboBox<> ();
        fromBox.setBounds(100, 150, 150, 30);
        add(fromBox);

        toBox = new JComboBox<> ();
        toBox.setBounds(340, 150, 150, 30);
        add(toBox);
        
        dateBox = new JComboBox<> ( new String[]{"Jan - Feb","March - April","May - Jun","Jul - Aug","Sep - Oct","Nov - Dec"});
        dateBox.setBounds(600, 150, 150, 30);
        add(dateBox);
        
        Model = new DefaultTableModel(new String []  {"Flight ID", "Departure"," Arrival","Price","Date", "Depart "},0);
        Table = new JTable(Model);
        Scroll = new JScrollPane(Table);
        Scroll.setBounds(50,210,860,530);
        add(Scroll);
        
        btnsearch = new JButton("Search");
        btnsearch.setBounds(800, 150, 110, 30);
        add(btnsearch);
        
        btnbook = new JButton("Book Flights");
        btnbook.setBounds(770, 760, 140, 30);
        add(btnbook);
        
        btnback = new JButton("Back");
        btnback.setBounds(40, 40, 90, 35);
        add(btnback);
     
        btnsearch.addActionListener(this);
        btnbook.addActionListener(this);
        btnback.addActionListener(this);
    
    }
    
    private void loadCites(){
         Connection conn = MysqlConnect.ConnectDB();
        if (conn == null) {
            return;
        }
        try {
            PreparedStatement pst = conn.prepareStatement(
                    "SELECT Departure AS city FROM flightsdb UNION SELECT Arrival FROM flightsdb ORDER BY city");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                fromBox.addItem(rs.getString("city"));
                toBox.addItem(rs.getString("city"));
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Could not load cities: " + ex.getMessage(),
                    "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void loadFlights() {
        
         if (fromBox.getSelectedItem() == null || toBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this,
                    "There are no flights yet. The admin has to add flights first.",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
         
         String origin = fromBox.getSelectedItem().toString();
         String destination = toBox.getSelectedItem().toString();
         String period = dateBox.getSelectedItem().toString();
         
         if (origin.equalsIgnoreCase(destination)) {
            JOptionPane.showMessageDialog(this, "Departure and arrival cities must be different.",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Model.setRowCount(0);
         Connection conn = MysqlConnect.ConnectDB();
        if (conn == null) {
            return;
        }
        try {
            String sql = "SELECT FlightId, Departure, Arrival, Price, `Date`, DepartureTime "
                    + "FROM flightsdb WHERE Departure = ? AND Arrival = ? AND `Date` = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, origin);
            pst.setString(2, destination);
            pst.setString(3, period);
            ResultSet rs = pst.executeQuery();
            flightTree tree = new flightTree();
            while (rs.next()) {
                LocalTime time = null;
                Time t = rs.getTime("DepartureTime");
                if (t != null) {
                    time = t.toLocalTime();
                }
                tree.add(new Flight(rs.getString("FlightId"), rs.getString("Departure"),
                        rs.getString("Arrival"), rs.getDouble("Price"), rs.getString("Date"), time));
            }
            conn.close();
            show = tree.inOrder();  

            
            for (Flight f : show) {
                Model.addRow(new Object[]{f.getFlightId(), f.getDeparture(), f.getArrival(),
                    String.format("%,.2f", f.getPrice()), f.getDate(), f.getDepartureTimeText()});
            }
            if (show.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No Available Flights!.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Could not load flights: " + ex.getMessage(),
                    "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnback){
            new dashboardGUI().setVisible(true);
            dispose();
        } else if (e.getSource() == btnsearch) {
            loadFlights();
        }  
      }
    
}
