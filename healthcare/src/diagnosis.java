import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;


public class diagnosis extends JFrame implements ActionListener {
    
JPanel jPanel1 = new JPanel();
JLabel jLabel1 = new JLabel();
JLabel jLabel2 = new JLabel();
JLabel jLabel3 = new JLabel();
JLabel jLabel4 = new JLabel();
JLabel jLabel5 = new JLabel();
JLabel jLabel6 = new JLabel();
JLabel jLabel7 = new JLabel();
JButton jButton1 = new JButton();
JButton jButton2 = new JButton();
JButton jButton3 = new JButton("Back");
static JTextField jTextField1 = new JTextField();
JTextField jTextField2 = new JTextField();
JTextField jTextField3 = new JTextField();
JTextField jTextField4 = new JTextField();
JTextField jTextField5 = new JTextField();
JTextField jTextField6 = new JTextField();
JTable jTable1 = new JTable();
JScrollPane jScrollPane = new JScrollPane();

diagnosis(){
    main m = new main();

    jLabel1.setFont(new java.awt.Font("Arial Black",2,30)); // NOI18N
    jLabel1.setText("Enter Diagnosis Detail");
    jLabel1.setForeground(Color.BLACK);
    jLabel1.setBounds(90, 10, 392, 35);

    jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel2.setText("Enter Patient's Id");
    jLabel2.setBounds(20, 70, 180, 25);
    jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel3.setText("Doctor's Name");
    jLabel3.setBounds(20, 190, 150, 25);
    jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel4.setText("Diagnosis");
    jLabel4.setBounds(20, 240, 111, 25);
    jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel5.setText("Medicine");
    jLabel5.setBounds(20, 290, 136, 25);
    jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel6.setText("Admitted");
    jLabel6.setBounds(20, 340, 150, 25);
    jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel7.setText("Ward number");
    jLabel7.setBounds(20, 390, 170, 25);

    jPanel1.setBackground(new java.awt.Color(m.a,m.b,m.c));
    jPanel1.setBounds(0, 0, 903, 570);

    jTextField6.setBounds(220, 390, 214, 32);
    jTextField5.setBounds(220, 340, 214, 32);
    jTextField4.setBounds(220, 290, 214, 32);
    jTextField3.setBounds(220, 240, 214, 32);
    jTextField2.setBounds(220, 190, 214, 32);
    jTextField1.setBounds(220, 70, 214, 32);

    jButton1.setBounds(120, 450, 184, 36);
    jButton1.setText("Add record");
    jButton1.setFont(new java.awt.Font("Segoe UI", 1, 21));
    jButton1.setFocusable(false);
    jButton1.addActionListener(this);
    jButton2.setBounds(90, 130, 72, 27);
    jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jButton2.setText("Enter");
    jButton2.setFocusable(false);
    jButton2.addActionListener(this);
    jButton3.setBounds(400, 450, 184, 36);
    jButton3.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
    jButton3.setFocusable(false);
    jButton3.addActionListener(this);

    jScrollPane.setBounds(220,110,600,70);
    jTable1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
        {null, null, null, null, null},
        {null, null, null, null, null},{null, null, null, null, null}
    },
    new String [] {
        "Name", "Contact No.", "Age", "Sex", "Disease"
    }
) {
    boolean[] canEdit = new boolean [] {
        false, false, false, false, false
    };

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
});
jScrollPane.setViewportView(jTable1);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setResizable(false);
    this.setBounds(400, 150, 903, 541);
    this.add(jScrollPane);
    this.add(jLabel1);
    this.add(jLabel2);
    this.add(jLabel3);
    this.add(jLabel4);
    this.add(jLabel5);
    this.add(jLabel6);
    this.add(jLabel7);
    this.add(jButton1);
    this.add(jButton2);
    this.add(jButton3);
    this.add(jTextField1);
    this.add(jTextField2);
    this.add(jTextField3);
    this.add(jTextField4);
    this.add(jTextField5);
    this.add(jTextField6);
    this.add(jPanel1);
    
    this.setVisible(true);
}

public static void main(String[] args) {
    new diagnosis();
}
@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==jButton2){
        try {
            String url = "jdbc:mysql://localhost:3306/hospital";
            String userName = "root";
            String password = "Ray@2004";
            Connection connection = DriverManager.getConnection(url, userName, password);
            String id = jTextField1.getText();
            String sql1 = "SELECT name,contact,age,sex,disease FROM patient WHERE patient_id = "+id;
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
                    v.add(resultSet.getString("contact"));
                    v.add(resultSet.getString("age"));
                    v.add(resultSet.getString("sex"));
                    v.add(resultSet.getString("disease"));
                }
                model.addRow(v);
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    if(e.getSource()==jButton1){
        try {
            String url = "jdbc:mysql://localhost:3306/hospital";
            String userName = "root";
            String password = "Ray@2004";
            Connection connection = DriverManager.getConnection(url, userName, password);
            String sql = "INSERT INTO diag (doctor, diagnosis , medicine , admitted , ward , patient_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement updateStatement = connection.prepareStatement(sql);
            String id = jTextField1.getText();
            String docString = jTextField2.getText();
            String diaString = jTextField3.getText();
            String medString = jTextField4.getText();
            String addmString = jTextField5.getText();
            String wdString = jTextField6.getText();
            updateStatement.setString(1, docString);
            updateStatement.setString(2, diaString);
            updateStatement.setString(3, medString);
            updateStatement.setString(4, addmString);
            updateStatement.setString(5, wdString);
            updateStatement.setString(6, id);
            updateStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Added Successfully!");
            this.dispose();
            new choose();

        } catch (Exception ep) {
            ep.printStackTrace();
        }
    }
    if(e.getSource()==jButton3){
        this.dispose();
        new choose();
    }
}
}

