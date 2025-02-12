import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;

public class bill extends JFrame implements ActionListener {

    JButton jButton1 = new JButton("Add Record");
    JButton jButton2 = new JButton("Back");
    JLabel label1 = new JLabel("Enter Patient's Details");
    JTextField textField3 = new JTextField();
    JTextField textField4 = new JTextField();
    JTextField textField5 = new JTextField();
    JTextField textField2 = new JTextField();
    JPanel jPanel1 = new JPanel();
    JLabel label3 = new JLabel("Patient Id:");
    JLabel label4 = new JLabel("Ward Fee:");
    JLabel label5 = new JLabel("Service Fee:");
    JLabel label6 = new JLabel("Doctor Fee:");
    bill(){
        main m = new main();
        jPanel1.setBackground(new java.awt.Color(m.a,m.b,m.c));
        jPanel1.setBounds(0, 0, 700, 570);

        textField3.setBounds(337, 183, 214, 32);
        textField4.setBounds(337, 243, 214, 32);
        textField5.setBounds(337, 303, 214, 32);
        textField2.setBounds(337, 123, 214, 32);
        jButton1.setBounds(170, 379, 184, 36);
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20));
        jButton1.setFocusable(false);
        jButton1.addActionListener(this);

        jButton2.setBounds(400, 379, 184, 36);
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 20));
        jButton2.setFocusable(false);
        jButton2.addActionListener(this);

        label1.setBounds(150, -70, 500, 200);
        label1.setFont(new Font("Arial Black", Font.ITALIC, 30));
        label1.setForeground(Color.BLACK);
        label3.setBounds(95, 123, 122, 32);
        label4.setBounds(95, 178, 111, 32);
        label5.setBounds(95, 238, 136, 32);
        label6.setBounds(95, 298, 150, 32);
        label3.setFont(new java.awt.Font("Segoe UI", 0, 24));
        label4.setFont(new java.awt.Font("Segoe UI", 0, 24));
        label5.setFont(new java.awt.Font("Segoe UI", 0, 24));
        label6.setFont(new java.awt.Font("Segoe UI", 0, 24));


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(400, 150, 700, 500);
        this.add(label3);this.add(label1);
        this.add(label4);this.add(textField3);
        this.add(textField4);this.add(jButton1);this.add(jButton2);
        this.add(textField5);
        this.add(textField2);
        this.add(label5);
        this.add(label6);
        this.add(jPanel1);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new bill();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {
            try {
                String url = "jdbc:mysql://localhost:3306/hospital";
                String userName = "root";
                String password = "Ray@2004";
                Connection connection = DriverManager.getConnection(url, userName, password);
                String sql = "INSERT INTO bill (ward_fee, service_fee, doctor_fee, total_fee, patient_id) VALUES ( ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                String genderString = textField2.getText();
                String addressString = textField3.getText();
                String conString = textField4.getText();
                String bgString = textField5.getText();
                String total = addressString+bgString+conString;

                preparedStatement.setString(1, addressString);
                preparedStatement.setString(2, conString);
                preparedStatement.setString(3, bgString);
                preparedStatement.setString(4, total);
                preparedStatement.setString(5, genderString);

                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Added Successfully!");
                this.dispose();
                new choose();
    }catch(Exception ep){
        ep.printStackTrace();
    }
}
if(e.getSource()==jButton2){
    this.dispose();
    new choose();
}
}
}