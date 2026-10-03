
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
        setSize (450,450);

        btnf = new JButton("Book flights");
        btnf.setBounds(80, 100, 120, 30);
        add(btnf);
        
        btnh = new JButton("Book hotel");
        btnh.setBounds(250, 100, 130, 30);
        add(btnh);
        
         btnp = new JButton("Book Package");
        btnp.setBounds(80, 150, 120, 30);
        add(btnp);
        
        btnbh = new JButton("Booking History");
        btnbh.setBounds(250, 150, 130, 30);
        add(btnbh);
       
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
