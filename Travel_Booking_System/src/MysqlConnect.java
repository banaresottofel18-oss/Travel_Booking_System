
import java.sql.*;
import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ottofel
 */

public class MysqlConnect {
    
    Connection conn = null;
    
    public static Connection ConnectDB(){
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelbookingsystem","root","");
            
            JOptionPane.showMessageDialog(null,"Database Connection is Succesfull");
            
            return conn;
            
        }catch(Exception e){
            
             JOptionPane.showMessageDialog(null,e);
            
             return null;
        }
        
        
        
    }
}
