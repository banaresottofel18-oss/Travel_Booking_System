import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
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
    private JTextField txtfrom, txtto, txtdate;
    private JButton btnsearch, btnbook, btnback;
    private JPanel flightPanel;
    
    flightsGUI(){
        setTitle ("Travel Booking System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        
        flights = new JLabel("Flights");
        flights.setBounds(430, 40, 150, 50);
        flights.setFont(flights.getFont().deriveFont(25.0f));
        add(flights);
    
        from = new JLabel("From:");
        from.setBounds(100, 150, 50, 30);
        add(from);
        
        to = new JLabel("To:");
        to.setBounds(350, 150, 40, 30);
        add(to);
        
        date = new JLabel("Date:");
        date.setBounds(590, 150, 50, 30);
        add(date);
        
        txtfrom = new JTextField();
        txtfrom.setBounds(155, 150, 150, 30);
        add(txtfrom);
        
        txtto = new JTextField();
        txtto.setBounds(395, 150, 150, 30);
        add(txtto);
        
        txtdate = new JTextField();
        txtdate.setBounds(640, 150, 150, 30);
        add(txtdate);
        
        btnsearch = new JButton("Search");
        btnsearch.setBounds(810, 150, 100, 30);
        add(btnsearch);
        
        btnbook = new JButton("Book");
        btnbook.setBounds(800, 850, 110, 40);
        add(btnbook);
        
        btnback = new JButton("Back");
        btnback.setBounds(40, 40, 90, 35);
        add(btnback);
        
        flightPanel = new JPanel();
        flightPanel.setBounds(100, 220, 810, 600);
        flightPanel.setBorder(BorderFactory.createTitledBorder("Available Flights"));
        add(flightPanel);
       
                
  
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
