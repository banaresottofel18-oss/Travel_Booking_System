import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;

public class bookinghistoryGUI extends JFrame {
 
    private JLabel history, flights, hotels, packages;
    private JPanel flightPanel, hotelPanel, packagePanel;
    private JButton btnback, btnview;
    private DefaultListModel<String> flightModel;
    private DefaultListModel<String> hotelModel;
    private DefaultListModel<String> packageModel;
    private JList<String> flightList;
    private JList<String> hotelList;
    private JList<String> packageList;
    
    bookinghistoryGUI(){
        
        setTitle("Travel Booking History");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
    }
    
}
