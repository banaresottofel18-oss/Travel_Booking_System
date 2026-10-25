
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ottofel
 */
public class dashboardGUI extends JFrame implements ActionListener {
    
        private JButton btnf, btnh,btnp,btnbh;
        
    dashboardGUI(){
        setTitle("Travel Booking System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize (1000,1000);

        btnf = new JButton("Book flights");
        btnf.setBounds(280, 350, 190, 50);
        add(btnf);
        
        btnh = new JButton("Book hotel");
        btnh.setBounds(530, 350, 190, 50);
        add(btnh);
        
         btnp = new JButton("Book Package");
        btnp.setBounds(280, 430, 190, 50);
        add(btnp);
        
        btnbh = new JButton("Booking History");
        btnbh.setBounds(530, 430, 190, 50);
        add(btnbh);
       
        btnf.addActionListener(this);
        
    }
    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnf) {
        flightsGUI flight = new flightsGUI();
        flight.setVisible(true);
        dispose();
    }

}
}
