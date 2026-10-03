
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
    
     private JLabel loginform,user,pass;
    private JTextField txtuser;
    private JPasswordField txtpass;
    private JButton btnlogin, btnclear;
    
      loginGUI(){
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
        
        btnlogin = new JButton("Log In");
        btnlogin.setBounds(240, 220, 70, 20);
        add(btnlogin);
        
        
        
        btnclear = new JButton("Clear");
        btnclear.setBounds(160, 220, 70, 20);
        add(btnclear);
        
        
        user = new JLabel();
        user.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        pass = new JLabel();
        add(loginform);
      }
      
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      
}
