
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ottofel
 */
public class addFlightGUI extends JFrame implements ActionListener {

    private JLabel title, lblid, lblfrom, lblto, lbldate, lblprice, lbltime;
    private JTextField txtid, txtfrom, txtto, txtprice, txttime;
    private JComboBox<String> dateBox;
    private JButton btnadd, btnback;
    private DefaultTableModel Model;
    private JTable Table;
    private JScrollPane Scroll;
    private String userSes;

    addFlightGUI(String userSes) {
        this.userSes = userSes;

        setTitle("Travel Booking System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);

        title = new JLabel("Add Flight");
        title.setBounds(420, 40, 300, 50);
        title.setFont(title.getFont().deriveFont(25.0f));
        add(title);

        lblid = new JLabel("Flight ID:");
        lblid.setBounds(50, 130, 70, 30);
        add(lblid);
        txtid = new JTextField();
        txtid.setBounds(120, 130, 100, 30);
        add(txtid);

        lblfrom = new JLabel("From:");
        lblfrom.setBounds(250, 130, 40, 30);
        add(lblfrom);
        txtfrom = new JTextField();
        txtfrom.setBounds(295, 130, 150, 30);
        add(txtfrom);

        lblto = new JLabel("To:");
        lblto.setBounds(470, 130, 30, 30);
        add(lblto);
        txtto = new JTextField();
        txtto.setBounds(505, 130, 150, 30);
        add(txtto);

        lbldate = new JLabel("Date:");
        lbldate.setBounds(680, 130, 40, 30);
        add(lbldate);
        dateBox = new JComboBox<>(new String[]{"Jan - Feb", "March - April", "May - Jun",
            "Jul - Aug", "Sep - Oct", "Nov - Dec"});
        dateBox.setBounds(725, 130, 150, 30);
        add(dateBox);

        lblprice = new JLabel("Price:");
        lblprice.setBounds(50, 180, 50, 30);
        add(lblprice);
        txtprice = new JTextField();
        txtprice.setBounds(105, 180, 115, 30);
        add(txtprice);

        lbltime = new JLabel("Departure time (HH:mm):");
        lbltime.setBounds(250, 180, 160, 30);
        add(lbltime);
        txttime = new JTextField();
        txttime.setBounds(415, 180, 80, 30);
        add(txttime);

        btnadd = new JButton("Add Flight");
        btnadd.setBounds(725, 180, 150, 30);
        add(btnadd);

        btnback = new JButton("Back");
        btnback.setBounds(40, 40, 90, 35);
        add(btnback);

        Model = new DefaultTableModel(
                new String[]{"Flight ID", "From", "To", "Price", "Date", "Departs At"}, 0);
        Table = new JTable(Model);
        Scroll = new JScrollPane(Table);
        Scroll.setBounds(50, 240, 860, 500);
        add(Scroll);

        btnadd.addActionListener(this);
        btnback.addActionListener(this);

      
        Connection conn = MysqlConnect.ConnectDB();
        if (conn != null) {
            try {
                PreparedStatement pst = conn.prepareStatement(
                        "SELECT FlightId, Departure, Arrival, Price, `Date`, DepartureTime FROM flightsdb");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    Model.addRow(new Object[]{
                        rs.getString("FlightId"), rs.getString("Departure"), rs.getString("Arrival"),
                        rs.getString("Price"), rs.getString("Date"), rs.getString("DepartureTime")
                    });
                }
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Could not load flights: " + ex.getMessage(),
                        "Database error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnback) {
            new dashboardGUI(userSes).setVisible(true);
            dispose();

        } else if (e.getSource() == btnadd) {
            String id = txtid.getText().trim();
            String from = txtfrom.getText().trim();
            String to = txtto.getText().trim();
            String date = dateBox.getSelectedItem().toString();

            if (id.isEmpty() || from.isEmpty() || to.isEmpty()
                    || txtprice.getText().trim().isEmpty() || txttime.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in every field first",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (from.equalsIgnoreCase(to)) {
                JOptionPane.showMessageDialog(this, "From and To must be different cities",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double price;
            try {
                price = Double.parseDouble(txtprice.getText().trim());
                if (price <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Price must be a number greater than 0",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }

            LocalTime time;
            try {
                time = LocalTime.parse(txttime.getText().trim()); 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Departure time must look like 08:30 or 14:45",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Connection conn = MysqlConnect.ConnectDB();
            if (conn == null) {
                return;
            }
            try {
                String sql = "INSERT INTO flightsdb (FlightId, Departure, Arrival, Price, `Date`, DepartureTime) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);
                pst.setString(2, from);
                pst.setString(3, to);
                pst.setDouble(4, price);
                pst.setString(5, date);
                pst.setString(6, time.toString());
                pst.executeUpdate();
                conn.close();

                JOptionPane.showMessageDialog(this, "Flight " + id + " added!");
                txtid.setText("");
                txtfrom.setText("");
                txtto.setText("");
                txtprice.setText("");
                txttime.setText("");
                Model.addRow(new Object[]{id, from, to, String.format("%.2f", price), date, time.toString()});
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                        "Could not add the flight (is that Flight ID already used?): " + ex.getMessage(),
                        "Database error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
