import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class patients extends JFrame implements ActionListener {
    JPanel jPanel1 = new JPanel();
    
    
    JLabel label1 = new JLabel("Enter Patient's Details");
    JLabel label2 = new JLabel("Name:");
    JLabel label3 = new JLabel("Gender:");
    JLabel label4 = new JLabel("Address:");
    JLabel label5 = new JLabel("Number:");
    JLabel label6 = new JLabel("Blood Group:");
    JLabel label7 = new JLabel("Age:");
    JLabel label8 = new JLabel("Id:");
    JLabel label9 = new JLabel("Disease:");
    
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();
    JTextField textField3 = new JTextField();
    JTextField textField4 = new JTextField();
    JTextField textField5 = new JTextField();
    JTextField textField6 = new JTextField();
    JTextField textField7 = new JTextField();
    JTextField textField8 = new JTextField();
    
    JButton jButton1 = new JButton("Add Record");
    JButton jButton2 = new JButton("Back");
    
    patients() {
        main m = new main();
        jPanel1.setBackground(new java.awt.Color(m.a,m.b,m.c));
        jPanel1.setBounds(0, 0, 700, 620);
        
        label1.setBounds(150, -70, 500, 200);
        label1.setFont(new Font("Arial Black", Font.ITALIC, 30));
        label1.setForeground(Color.BLACK);

        label2.setFont(new java.awt.Font("Segoe UI", 0, 24));
        label3.setFont(new java.awt.Font("Segoe UI", 0, 24));
        label4.setFont(new java.awt.Font("Segoe UI", 0, 24));
        label5.setFont(new java.awt.Font("Segoe UI", 0, 24));
        label6.setFont(new java.awt.Font("Segoe UI", 0, 24));
        label7.setFont(new java.awt.Font("Segoe UI", 0, 24));
        label8.setFont(new java.awt.Font("Segoe UI", 0, 24));
        label9.setFont(new java.awt.Font("Segoe UI", 0, 24));
        label2.setBounds(95, 72, 80, 25);
        label3.setBounds(95, 123, 102, 32);
        label4.setBounds(95, 178, 111, 32);
        label5.setBounds(95, 238, 136, 32);
        label6.setBounds(95, 298, 150, 32);
        label7.setBounds(95, 472, 113, 32);
        label8.setBounds(95, 413, 37, 32);
        label9.setBounds(95, 358, 136, 32);

        jButton1.setBounds(186, 535, 164, 36);
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20));
        jButton1.setFocusable(false);
        jButton1.addActionListener(this);
        jButton2.setBounds(400, 535, 164, 36);
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 20));
        jButton2.setFocusable(false);
        jButton2.addActionListener(this);


        textField1.setBounds(337, 72, 214, 33);
        textField2.setBounds(337, 123, 214, 32);
        textField3.setBounds(337, 183, 214, 32);
        textField4.setBounds(337, 243, 214, 32);
        textField5.setBounds(337, 303, 214, 32);
        textField6.setBounds(337, 363, 214, 32);
        textField7.setBounds(337, 413, 214, 32);
        textField8.setBounds(337, 463, 214, 36);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(400, 130, 700, 650); 
        
        this.add(jButton1);
        this.add(jButton2);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(label8);
        this.add(label9);
        this.add(textField1);
        this.add(textField2);
        this.add(textField3);
        this.add(textField4);
        this.add(textField5);
        this.add(textField6);
        this.add(textField7);
        this.add(textField8);
        this.add(jPanel1);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new patients();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {
            try {
                String url = "jdbc:mysql://localhost:3306/hospital";
                String userName = "root";
                String password = "Ray@2004";
                Connection connection = DriverManager.getConnection(url, userName, password);
                String sql = "INSERT INTO patient (name, address, contact, age, sex, blood_group, disease, patient_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                String nameString = textField1.getText();
                String genderString = textField2.getText();
                String addressString = textField3.getText();
                String conString = textField4.getText();
                String bgString = textField5.getText();
                String disString = textField6.getText();
                String idString = textField7.getText();
                int ageString = Integer.parseInt(textField8.getText());

                preparedStatement.setString(1, nameString);
                preparedStatement.setString(2, addressString);
                preparedStatement.setString(3, conString);
                preparedStatement.setInt(4, ageString);
                preparedStatement.setString(5, genderString);
                preparedStatement.setString(6, bgString);
                preparedStatement.setString(7, disString);
                preparedStatement.setString(8, idString);

                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Patient Added Successfully!");
                this.dispose();
                new choose();
            } catch (SQLException exp) {
                System.out.println("NOO");
            }
        }
        if(e.getSource()==jButton2){
            this.dispose();
            new choose();
        }
    }
}
