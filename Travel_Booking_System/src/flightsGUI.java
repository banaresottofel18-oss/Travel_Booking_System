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
        setSize(450, 450);
        
        flights = new JLabel("Flights");
        flights.setBounds(175, 30, 100, 40);
        flights.setFont(flights.getFont().deriveFont(25.0f));
        add(flights);
    
        from = new JLabel("From:");
        from.setBounds(30, 100, 45, 25);
        add(from);
        
        to = new JLabel("To:");
        to.setBounds(165, 100, 30, 25);
        add(to);
        
        date = new JLabel("Date:");
        date.setBounds(285, 100, 40, 25);
        add(date);
        
        txtfrom = new JTextField();
        txtfrom.setBounds(75, 100, 80, 25);
        add(txtfrom);
        
        txtto = new JTextField();
        txtto.setBounds(195, 100, 80, 25);
        add(txtto);
        
        txtdate = new JTextField();
        txtdate.setBounds(325, 100, 70, 25);
        add(txtdate);
        
        btnsearch = new JButton("Search");
        btnsearch.setBounds(325, 135, 90, 25);
        add(btnsearch);
        
        btnbook = new JButton("Book");
        btnbook.setBounds(325, 375, 70, 30);
        add(btnbook);
        
        btnback = new JButton("Back");
        btnback.setBounds(20, 20, 70, 30);
        add(btnback);
        
        flightPanel = new JPanel();
        flightPanel.setBounds(30, 170, 365, 190);
        flightPanel.setBorder(BorderFactory.createTitledBorder("Available Flights"));
        add(flightPanel);
       
                
  
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
