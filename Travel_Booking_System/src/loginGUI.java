import java.sql.*;
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
public class loginGUI extends JFrame implements ActionListener {
    
    private JLabel loginform,user,pass,noacc;
    private JTextField txtuser;
    private JPasswordField txtpass;
    private JButton btnlogin, btnclear,btncacc;
    private JCheckBox showpass;
    private String  userSes;
   
    // Connection
    Connection conn = null;
    ResultSet  rs =  null;
    PreparedStatement pst = null;
    
      loginGUI(){
        
        conn = MysqlConnect.ConnectDB();
        
        
        setTitle("Travel Booking System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize (450,450);
         
        loginform = new JLabel("Log In");
        loginform.setBounds(180, 30, 80, 100);
        loginform.setFont(loginform.getFont().deriveFont(25.0f));
        add(loginform);
        
        user= new JLabel("Username:");
        user.setBounds(90, 80, 80, 100);
        user.setFont(user.getFont().deriveFont(12.0f));
        add(user);
        
        pass= new JLabel("Password:");
        pass.setBounds(90, 120, 80, 100);
        pass.setFont(pass.getFont().deriveFont(12.0f));
        add(pass);
        
        txtuser = new JTextField();
        txtuser.setBounds(160, 120, 150, 20);
        add(txtuser);
        
         txtpass = new JPasswordField();
        txtpass.setBounds(160, 160, 150, 20);
        add(txtpass);
        
        showpass = new JCheckBox("Show Password");
        showpass.setBounds(160, 185, 150, 25);
        add(showpass); 
        showpass.addActionListener(this);
        
        btnlogin = new JButton("Log In");
        btnlogin.setBounds(240, 220, 70, 20);
        btnlogin.addActionListener(this);
        add(btnlogin);
        
        btnclear = new JButton("Clear");
        btnclear.setBounds(160, 220, 70, 20);
        btnclear.addActionListener(this);
        add(btnclear);
        
        btncacc = new JButton("Create New  Acc");
        btncacc.setBounds(160, 290, 150, 25);
        btncacc.addActionListener(this);
        add(btncacc);
        
        noacc= new JLabel("No Account?");
        noacc.setBounds(200, 260, 150, 25);
        noacc.setFont(noacc.getFont().deriveFont(12.0f));
        add(noacc);
        
        
      }
      
    @Override
    public void actionPerformed(ActionEvent e) {
    
        
        if (e.getSource() == btnclear) {
                txtuser.setText("");
                txtpass.setText("");
                txtuser.requestFocus();
                return;
                
        }   if (e.getSource() == showpass) {
              if (showpass.isSelected()) {
            txtpass.setEchoChar((char) 0);
        } else {
            txtpass.setEchoChar('•');
        }
      
    }
         if (e.getSource() == btncacc) {
            CreateAccGUI register = new CreateAccGUI();
            register.setVisible(true);
            this.dispose();
            return;
         }
         if (e.getSource() == btnlogin) {

        if (conn == null) {
            JOptionPane.showMessageDialog(
                this, "Database connection failed.");
            return;
        }

        String username = txtuser.getText().trim();
        String password = new String(txtpass.getPassword());

      
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Please enter your username and password.");
            return;
        }

              
              
      try {
           String sql = "SELECT * FROM logindb " +" where username=? AND password =?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtuser.getText().trim());
            pst.setString(2, new String(txtpass.getPassword()));

            rs = pst.executeQuery();
              
              if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                
                 CustomerTable customers = new CustomerTable();
                pst = conn.prepareStatement("SELECT username, password FROM logindb");
                rs = pst.executeQuery();
                while (rs.next()) {
                    customers.put(new Customer(rs.getString("username"), rs.getString("password")));
                }
                Customer customer = customers.get(username);
                
              if (customer != null) {
                    userSes = customer.getUserId();
                } else {
                    userSes = username;
                }
                // Open Dashboard
                dashboardGUI dashboard = new dashboardGUI(userSes);
                dashboard.setVisible(true);
                // Close Login Frame
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(
                    this, "Incorrect username or password");
            }
     }catch (SQLException ex) {
       JOptionPane.showMessageDialog(this, "Login failed: " + ex.getMessage(),
                    "Database error", JOptionPane.ERROR_MESSAGE);
     }
         }
    }
}
     
        
   