import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class history extends JFrame implements ActionListener {


    JLabel jLabel1 = new JLabel("Patient's Detail:");
    JLabel jLabel2 = new JLabel("Patient's Name:");
    JLabel jLabel3 = new JLabel("Address:");
    JLabel jLabel4 = new JLabel("Contact:");
    JLabel jLabel5 = new JLabel("Age:");
    JLabel jLabel6 = new JLabel("Sex:");
    JLabel jLabel9 = new JLabel("Blood Group:");
    JLabel jLabel7 = new JLabel("Doctor's Name:");
    JLabel jLabel8 = new JLabel("Diagnosis:");
    JLabel jLabel10 = new JLabel("Medicine:");
    JLabel jLabel11 = new JLabel("Doctor's Fee:");
    JLabel jLabel12 = new JLabel("Service Fee:");
    JLabel jLabel13 = new JLabel("Ward Fee:");
    JLabel jLabel14 = new JLabel("Total Fee:");
    JLabel jLabel15 = new JLabel("Enter Patient's Id:");

    JTextField jTextField1 = new JTextField();
    JTextField jTextField2 = new JTextField();
    JTextField jTextField3 = new JTextField();
    JTextField jTextField4 = new JTextField();
    JTextField jTextField5 = new JTextField();
    JTextField jTextField6 = new JTextField();
    JTextField jTextField7 = new JTextField();
    JTextField jTextField8 = new JTextField();
    JTextField jTextField9 = new JTextField();
    JTextField jTextField10 = new JTextField();
    JTextField jTextField11 = new JTextField();
    JTextField jTextField12 = new JTextField();
    JTextField jTextField13 = new JTextField();
    JTextField jTextField14 = new JTextField();

    JPanel jPanel1 = new JPanel();

    JButton jButton1 = new JButton("BACK");
    JButton jButton2 = new JButton("ENTER");
    Statement s = null;
    
    
    history(){
        
        jLabel1.setFont(new java.awt.Font("Arial Black", 2, 30));jLabel1.setBounds(90, 10, 392, 35);
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); jLabel2.setBounds(30, 120, 180, 25);
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); jLabel3.setBounds(30, 150, 150, 20);
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); jLabel4.setBounds(30, 180, 111, 25);
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); jLabel5.setBounds(30, 210, 136, 20);
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14));jLabel6.setBounds(30, 240, 150, 20);
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14));jLabel9.setBounds(30, 270, 170, 20);
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14));jLabel7.setBounds(30, 300, 110, 20);
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14));jLabel8.setBounds(30, 330, 100, 16);
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); jLabel10.setBounds(30, 360, 90, 20);
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14));jLabel11.setBounds(30, 400, 100, 20);
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); jLabel12.setBounds(30, 430, 120, 20);
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); jLabel13.setBounds(30, 460, 80, 20);
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); jLabel14.setBounds(30, 490, 80, 16);
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); jLabel15.setBounds(30, 60, 120, 20);
        
        jTextField1.setBounds(190, 120, 214, 20);jTextField2.setBounds(190, 150, 214, 20);
        jTextField3.setBounds(190, 180, 214, 20);jTextField4.setBounds(190, 210, 214, 20);
        jTextField5.setBounds(190, 240, 214, 20);jTextField6.setBounds(190, 270, 214, 20);
        jTextField7.setBounds(190, 300, 214, 20);jTextField8.setBounds(190, 330, 214, 22);
        jTextField9.setBounds(190, 360, 214, 22);jTextField10.setBounds(190, 400, 214, 22);
        jTextField11.setBounds(190, 430, 214, 22);jTextField12.setBounds(190, 460, 214, 22);
        jTextField13.setBounds(190, 490, 214, 22);jTextField14.setBounds(190, 60, 214, 22);
        
        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBounds(0, 0, 503, 679);
        // jTextField1.setEditable(false);jTextField2.setEditable(false);
        // jTextField3.setEditable(false);jTextField4.setEditable(false);
        // jTextField5.setEditable(false);jTextField6.setEditable(false);
        // jTextField7.setEditable(false);jTextField8.setEditable(false);
        // jTextField9.setEditable(false);jTextField10.setEditable(false);
        // jTextField11.setEditable(false);jTextField12.setEditable(false);
        // jTextField13.setEditable(false);
        
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24));jButton1.setBounds(170, 550, 130, 36);
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18));jButton2.setBounds(375, 85, 100, 28);
        jButton2.setFocusable(false);
        jButton1.addActionListener(this);jButton2.addActionListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(550, 80, 503, 639);
        this.add(jButton1);this.add(jButton2);
        this.add(jLabel1);this.add(jTextField1);
        this.add(jLabel2);this.add(jTextField2);
        this.add(jLabel3);this.add(jTextField3);
        this.add(jLabel4);this.add(jTextField4);
        this.add(jLabel5);this.add(jTextField5);
        this.add(jLabel6);this.add(jTextField6);
        this.add(jLabel7);this.add(jTextField7);
        this.add(jLabel8);this.add(jTextField8);
        this.add(jLabel9);this.add(jTextField9);
        this.add(jLabel10);this.add(jTextField10);
        this.add(jLabel11);this.add(jTextField11);
        this.add(jLabel12);this.add(jTextField12);
        this.add(jLabel13);this.add(jTextField13);
        this.add(jLabel14);this.add(jTextField14);
        this.add(jLabel15);this.add(jPanel1);
        
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new history();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== jButton2){
            String url = "jdbc:mysql://localhost:3306/hospital";
            String userName = "root";
            String password = "Ray@2004";
            try {
                
                Connection connection = DriverManager.getConnection(url, userName, password);
                s = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                String id = jTextField1.getText();
                String sql1 = "SELECT * FROM patient WHERE patient_id = "+id;
                // PreparedStatement stm = connection.prepareStatement(sql1);
                // ResultSet resultSet = stm.executeQuery(sql1);
                ResultSet rs =  ((java.sql.Statement) s).executeQuery(sql1);
                if(rs.next()){
                    jTextField1.setText(rs.getString("name"));
                    jTextField2.setText(rs.getString(2));
                    jTextField3.setText(rs.getString(3));
                    jTextField4.setText(rs.getString(4));
                    jTextField5.setText(rs.getString(5));
                    jTextField6.setText(rs.getString(6));
                    jTextField7.setText(rs.getString(7));
                }

            } catch (Exception ep) {
                // TODO: handle exception
            }
        }
    }
    
}
