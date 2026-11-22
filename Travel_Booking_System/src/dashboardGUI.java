import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Font;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ottofel
 */
public class dashboardGUI extends JFrame implements ActionListener {
    
        private JButton btnf, btnh, btnp, btnbh, btnaf, btnlogout,btnah, btnap;
        private JLabel welcome, text1, text2, services, desc, footer, line1, line2;
            private String userSes;
        
    dashboardGUI( String userSes){
        this.userSes = userSes;
        
        setTitle("Travel Booking System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize (1000,1000);

        btnf = new JButton("Book Flights");
        btnf.setBounds(280, 430, 190, 55);
        btnf.setFont(new Font("Arial", Font.BOLD, 16));
        add(btnf);
        
        btnh = new JButton("Book Hotel");
        btnh.setBounds(530, 430, 190, 55);
        btnh.setFont(new Font("Arial", Font.BOLD, 16));
        add(btnh);
        
        btnp = new JButton("Book Package");
        btnp.setBounds(280, 505, 190, 55);
        btnp.setFont(new Font("Arial", Font.BOLD, 16));
        add(btnp);
        
        btnbh = new JButton("Booking History");
        btnbh.setBounds(530, 505, 190, 55);
        btnbh.setFont(new Font("Arial", Font.BOLD, 16));
        add(btnbh);
        btnlogout = new JButton("Logout");
        btnlogout.setBounds(420, 740, 160, 45);
        add(btnlogout);
        btnlogout.addActionListener(this);
       
        btnf.addActionListener(this);
        btnh.addActionListener(this);
        btnbh.addActionListener(this);
        btnp.addActionListener(this);
        
        
        if ("admin".equals(userSes)) {
            btnaf = new JButton("Add Flight");
            btnaf.setBounds(230, 640, 160, 50);
            add(btnaf);

            btnah = new JButton("Add Hotel");
            btnah.setBounds(420, 640, 160, 50);
            add(btnah);

            btnap = new JButton("Add Package");
            btnap.setBounds(610, 640, 160, 50);
            add(btnap);

            btnaf.addActionListener(this);
            btnah.addActionListener(this);
            btnap.addActionListener(this);
        }
        welcome = new JLabel("Welcome!!");
        welcome.setBounds(250, 100, 500, 45);
        welcome.setFont(new Font("Arial", Font.BOLD, 30));
        welcome.setHorizontalAlignment(JLabel.CENTER);
        add(welcome);
        
        text1 = new JLabel("Ready for Your Next Adventure?");
        text1.setBounds(150, 155, 700, 40);
        text1.setFont(new Font("Arial", Font.BOLD, 26));
        text1.setHorizontalAlignment(JLabel.CENTER);
        add(text1);
        
        text2 = new JLabel("Explore destinations, discover deals, and plan your perfect trip.");
        text2.setBounds(150, 205, 700, 30);
        text2.setFont(new Font("Arial", Font.PLAIN, 17));
        text2.setHorizontalAlignment(JLabel.CENTER);
        add(text2);
        
        line1 = new JLabel("_____________________________________________________________________________________________________________________________________________");
        line1.setBounds(30, 255, 940, 20);
        add(line1);
        
        services = new JLabel("Explore Our Services");
        services.setBounds(130, 300, 400, 35);
        services.setFont(new Font("Arial", Font.BOLD, 23));
        add(services);
        
        desc = new JLabel("Choose a service below to start planning your trip.");
        desc.setBounds(130, 340, 600, 30);
        desc.setFont(new Font("Arial", Font.PLAIN, 16));
        add(desc);
        
        line2 = new JLabel("_____________________________________________________________________________________________________________________________________________");
        line2.setBounds(30, 845, 940, 20);
        add(line2);
        
        footer = new JLabel("Travel with ease. Explore with confidence.");
        footer.setBounds(200, 870, 600, 30);
        footer.setFont(new Font("Arial", Font.PLAIN, 14));
        footer.setHorizontalAlignment(JLabel.CENTER);
        add(footer);
        
    }
    @Override
public void actionPerformed(ActionEvent e) {
   if (e.getSource() == btnf) {
            flightsGUI flight = new flightsGUI(userSes);
            flight.setVisible(true);
            dispose();
    }  
    else if (e.getSource() == btnh){
        hotelGUI hotel = new hotelGUI(userSes);
        hotel.setVisible(true);
        dispose();
    }
    else if (e.getSource() == btnp) {
            packageGUI pack = new packageGUI(userSes);
            pack.setVisible(true);
            dispose();
    }
    else if (e.getSource() == btnbh) {
         bookinghistoryGUI history = new bookinghistoryGUI(userSes);
         history.setVisible(true);
         dispose();
     }
   else if (e.getSource() == btnaf) {
            new addFlightGUI(userSes).setVisible(true);
            dispose();
    }
   else if (e.getSource() == btnlogout) {
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?",
                    "Logout", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                new loginGUI().setVisible(true);
                dispose();
            
            }
   }
}


}
