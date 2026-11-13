
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
    private JCheckBox showpass1,showpass2;
    private CustomerTable customers = new CustomerTable();
    
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
        
        showpass1 = new JCheckBox("Show Password");
        showpass1.setBounds(170, 185, 160, 25);
        add(showpass1); 
        showpass1.addActionListener(this);

        confirm = new JLabel("Confirm:");
        confirm.setBounds(70, 210, 90, 25);
        add(confirm);

        txtconfirm = new JPasswordField();
        txtconfirm.setBounds(170, 210, 160, 25);
        add(txtconfirm);
        
        showpass2 = new JCheckBox("Show Password");
        showpass2.setBounds(170, 235, 160, 25);
        add(showpass2); 
        showpass2.addActionListener(this);

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
        
         if (e.getSource() == showpass1) {
              if (showpass1.isSelected()) {
            txtpass.setEchoChar((char) 0);
        } else {
            txtpass.setEchoChar('•');
        }
    }
      else if (e.getSource() == showpass2) {
              if (showpass2.isSelected()) {
            txtconfirm.setEchoChar((char) 0);
        } else {
            txtconfirm  .setEchoChar('•');
        }
      
    }
       if (e.getSource() == btnback) {
            new loginGUI().setVisible(true);
            dispose();
       } else if (e.getSource() == btnregister) {
            String username = txtuser.getText().trim();
            String password = new String(txtpass.getPassword());
            String again = new String(txtconfirm.getPassword());

            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed.");
                return;
            }
            if (username.length() < 3 || password.length() < 3) {
                JOptionPane.showMessageDialog(this,
                        "Username and passowrd needs 3 or more characters.",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
             if (!password.equals(again)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
             }                                                                                  
             if (customers.contains(username)) {
                JOptionPane.showMessageDialog(this, "That username is already taken.",  
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
             try {
                pst = conn.prepareStatement("INSERT INTO logindb (username, password) VALUES (?, ?)");
                pst.setString(1, username);
                pst.setString(2, password);
                pst.executeUpdate();

                customers.put(new Customer(username, password));
                JOptionPane.showMessageDialog(this, "Account created! You can log in now.");
                new loginGUI().setVisible(true);
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "already have account");
            }
       }
    }
}