import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;


public class packageGUI extends JFrame implements ActionListener {

    private JLabel Package, from, to, date;
    private JTextField txtfrom, txtto, txtdate;
    private JButton btnsearch, btnbook, btnback;
    private JPanel packagePanel;

    packageGUI() {
        setTitle("Travel Booking System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        Package = new JLabel("Package");
        Package.setBounds(430, 40, 150, 50);
        add(Package);

        from = new JLabel("From:");
        from.setBounds(100, 150, 50, 30);
        add(from);

        to = new JLabel("To:");
        to.setBounds(350, 150, 40, 30);
        add(to);

        date = new JLabel("Date:");
        date.setBounds(590, 150, 50, 30);
        add(date);

        txtfrom = new JTextField();
        txtfrom.setBounds(155, 150, 150, 30);
        add(txtfrom);

        txtto = new JTextField();
        txtto.setBounds(395, 150, 150, 30);
        add(txtto);

        txtdate = new JTextField();
        txtdate.setBounds(640, 150, 150, 30);
        add(txtdate);

        btnsearch = new JButton("Search");
        btnsearch.setBounds(810, 150, 100, 30);
        add(btnsearch);

        packagePanel = new JPanel();
        packagePanel.setLayout(null);
        packagePanel.setBounds(100, 220, 810, 350);
        packagePanel.setBorder(
            BorderFactory.createTitledBorder("Available Package")
        );
        add(packagePanel);

        btnbook = new JButton("Book");
        btnbook.setBounds(800, 590, 110, 40);
        add(btnbook);

        btnback = new JButton("Back");
        btnback.setBounds(40, 40, 90, 35);
        add(btnback);

        btnsearch.addActionListener(this);
        btnbook.addActionListener(this);
        btnback.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnback) {
            new packageGUI().setVisible(true);
            dispose();
        }

        if (e.getSource() == btnsearch) {
            // Search button GUI only
        }

        if (e.getSource() == btnbook) {
            // Book button GUI only
        }
    }
}