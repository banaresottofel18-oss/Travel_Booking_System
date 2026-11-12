
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ottofel
 */
public class CreateAccGUI extends JFrame implements ActionListener {
    private JLabel title, user, pass, confirm;
    private JTextField txtuser;
    private JPasswordField txtpass, txtconfirm;
    private JButton btnregister, btnback;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
       CreateAccGUI() {
        conn = MysqlConnect.ConnectDB();
        

        setTitle("Travel Booking System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);

        title = new JLabel("Create Account");
        title.setBounds(130, 30, 250, 100);
        title.setFont(title.getFont().deriveFont(25.0f));
        add(title);

        user = new JLabel("Username:");
        user.setBounds(70, 110, 90, 25);
        add(user);

        txtuser = new JTextField();
        txtuser.setBounds(170, 110, 160, 25);
        add(txtuser);

        pass = new JLabel("Password:");
        pass.setBounds(70, 160, 90, 25);
        add(pass);

        txtpass = new JPasswordField();
        txtpass.setBounds(170, 160, 160, 25);
        add(txtpass);

        confirm = new JLabel("Confirm:");
        confirm.setBounds(70, 210, 90, 25);
        add(confirm);

        txtconfirm = new JPasswordField();
        txtconfirm.setBounds(170, 210, 160, 25);
        add(txtconfirm);

        btnregister = new JButton("Register");
        btnregister.setBounds(230, 270, 100, 28);
        btnregister.addActionListener(this);
        add(btnregister);

        btnback = new JButton("Back");
        btnback.setBounds(110, 270, 100, 28);
        btnback.addActionListener(this);
        add(btnback);          
    }
        private void loadCustomers() {
        if (conn == null) {
            return;
        }
        try {
            pst = conn.prepareStatement("SELECT username, password FROM logindb");
            rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Could not load users: " + ex.getMessage(),
                    "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
       
            
            
            
            
            
            
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == btnback) {
            new loginGUI().setVisible(true);
            dispose();
       }
      
    }
}