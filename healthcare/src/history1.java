import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class history1 extends JFrame implements ActionListener{
    
    JTable jTable1 = new JTable();
    JTable jTable2 = new JTable();
    JTable jTable3 = new JTable();
    JButton jButton1 = new JButton("BACK");
    JButton jButton2 = new JButton("ENTER");
    JLabel jLabel15 = new JLabel("Enter Patient's Id:");JLabel jLabel1 = new JLabel("Patient's Detail:");
    JTextField jTextField = new JTextField();
    JScrollPane jScrollPane1 = new JScrollPane();JPanel jPanel1 = new JPanel();
    JScrollPane jScrollPane2 = new JScrollPane();JScrollPane jScrollPane3 = new JScrollPane();


    history1(){
        main m = new main();
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); jLabel15.setBounds(30, 60, 120, 20);
        jLabel1.setFont(new java.awt.Font("Arial Black", 2, 30));jLabel1.setBounds(90, 10, 392, 35);

        jPanel1.setBackground(new java.awt.Color(m.a,m.b,m.c));
        jPanel1.setBounds(0, 0, 785, 596);

        jTextField.setBounds(190, 60, 210, 22);
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18));jButton2.setBounds(480, 60, 100, 32);
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24));jButton1.setBounds(280, 510, 130, 36);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Patient's Name", "Address", "Contact", "Age", "Sex", "Blood Group"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.setBounds(10, 110, 740, 100);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Doctor's Name", "Diagnosis", "Medicine"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        jScrollPane2.setBounds(120, 220, 452, 120);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Doctor's Fee", "Service Fee", "Ward Fee", "Total Fees"
            }
        ));
        jScrollPane3.setViewportView(jTable3);
        jScrollPane3.setBounds(120, 360, 460, 130);
            jButton2.setFocusable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(400, 100, 785, 596);
        this.add(jLabel1);this.add(jLabel15);
        this.add(jButton1);this.add(jButton2);
        this.add(jScrollPane1);this.add(jTextField);
        this.add(jScrollPane2);
        this.add(jScrollPane3);
        this.add(jPanel1);
        
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new history1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String url = "jdbc:mysql://localhost:3306/hospital";
        String userName = "root";
        String password = "Ray@2004";
        if(e.getSource()==jButton2){
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String id = jTextField.getText();
            String sql1 = "SELECT name,address,contact,age,sex,blood_group FROM patient WHERE patient_id = "+id;
            PreparedStatement stm = connection.prepareStatement(sql1);
            ResultSet resultSet = stm.executeQuery(sql1);
            ResultSetMetaData metaData =(ResultSetMetaData) resultSet.getMetaData();
            int n = metaData.getColumnCount();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector v = new Vector();
                for (int i=1 ;i<=n ;i++){
                    v.add(resultSet.getString("name"));
                    v.add(resultSet.getString("address"));
                    v.add(resultSet.getString("contact"));
                    v.add(resultSet.getString("age"));
                    v.add(resultSet.getString("sex"));
                    v.add(resultSet.getString("blood_group"));
                }
                model.addRow(v);
            }

            table2();
            table3();
            
        }catch (Exception se) {
            se.printStackTrace();
        }
    }

    if(e.getSource()==jButton1){
        this.dispose();
        new choose();
    }
}
public void table2(){
    String url = "jdbc:mysql://localhost:3306/hospital";
        String userName = "root";
        String password = "Ray@2004";
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String id = jTextField.getText();
            String sql1 = "SELECT doctor,diagnosis,medicine FROM diag WHERE patient_id = "+id;
            PreparedStatement stm = connection.prepareStatement(sql1);
            ResultSet resultSet = stm.executeQuery(sql1);
            ResultSetMetaData metaData =(ResultSetMetaData) resultSet.getMetaData();
            int n = metaData.getColumnCount();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector v = new Vector();
                for (int i=1 ;i<=n ;i++){
                    v.add(resultSet.getString("doctor"));
                    v.add(resultSet.getString("diagnosis"));
                    v.add(resultSet.getString("medicine"));
                }
                model.addRow(v);
            }
        }catch(Exception ep){
            ep.printStackTrace();
        }
}
public void table3(){
    String url = "jdbc:mysql://localhost:3306/hospital";
        String userName = "root";
        String password = "Ray@2004";
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String id = jTextField.getText();
            String sql1 = "SELECT doctor_fee,service_fee,ward_fee,total_fee FROM bill WHERE patient_id = "+id;
            PreparedStatement stm = connection.prepareStatement(sql1);
            ResultSet resultSet = stm.executeQuery(sql1);
            ResultSetMetaData metaData =(ResultSetMetaData) resultSet.getMetaData();
            int n = metaData.getColumnCount();
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector v = new Vector();
                for (int i=1 ;i<=n ;i++){
                    v.add(resultSet.getString("doctor_fee"));
                    v.add(resultSet.getString("service_fee"));
                    v.add(resultSet.getString("ward_fee"));
                    v.add(resultSet.getString("total_fee"));
                }
                model.addRow(v);
            }
        }catch(Exception ep){
            ep.printStackTrace();
        }
}
}