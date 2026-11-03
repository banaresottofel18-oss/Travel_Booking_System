import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
 
        fromBox = new JComboBox<> ( new String[]{"Manila","Cebu "," Iloilo" ," Bacolod", "kalibo"," tacloban"," Bohol"," Davao"," Cagayan de Oro"," General Santos"," Zamboanga"," Butuan"," Dipolog "});
        fromBox.setBounds(100, 150, 150, 30);
        add(fromBox);

        toBox = new JComboBox<> ( new String[]{"Manila","Cebu "," Iloilo" ," Bacolod", "kalibo"," tacloban"," Bohol"," Davao"," Cagayan de Oro"," General Santos"," Zamboanga"," Butuan"," Dipolog "});
        toBox.setBounds(340, 150, 150, 30);
        add(toBox);
        
        dateBox = new JComboBox<> ( new String[]{"Jan - Feb","March - April","May - Jun","Jul - Aug","Sep - Oct","Nov - Dec"});
        dateBox.setBounds(600, 150, 150, 30);
        add(dateBox);
        
        Model = new DefaultTableModel(new String []  {"Flight ID", "Departure"," Arrival","Price","Date"},0);
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
    private void loadFlights() {
      
        Model.setRowCount(0); 
 
        String sql = "SELECT `FlightId`, `Departure`, `Arrival`, `Price`, `Date` "
                   + "FROM `flightsdb` WHERE `Departure` = ? AND `Arrival` = ? AND `Date` = ?";
 
        try (Connection conn = MysqlConnect.ConnectDB()) {
            if (conn == null) {
                return; 
            }
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, fromBox.getSelectedItem().toString().trim());
                ps.setString(2, toBox.getSelectedItem().toString().trim());
                ps.setString(3, dateBox.getSelectedItem().toString().trim());
 
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Model.addRow(new Object[]{
                            rs.getString("FlightId"),
                            rs.getString("Departure"),
                            rs.getString("Arrival"),
                            rs.getString("Price"),
                            rs.getString("Date")
                        });
                    }
                }
            }
            if (Model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No Available Flights!.");
            }
        } catch (Exception ex) {
             ex.printStackTrace();
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
