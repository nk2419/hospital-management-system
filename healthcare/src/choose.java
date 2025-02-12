import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class choose extends JFrame implements ActionListener{

    JPanel jPanel1 = new JPanel();
    JButton patient = new JButton("Add New Patient");
    JButton diagnosis = new JButton("Add Patient Diagnosis ");
    JButton history = new JButton("Get Patient Record");
    JButton bill = new JButton("Add Bill Information");
    JButton exit = new JButton("Exit");
    JButton credits = new JButton("Credits");
    JLabel label = new JLabel("Choose the task");
    choose (){
        main m = new main();
        jPanel1.setBackground(new java.awt.Color(m.a, m.b, m.c));
        jPanel1.setBounds(0, 0, 700, 600);

        label.setFont(new java.awt.Font("Arial Black", 2, 30));label.setBounds(150, 20, 392, 35);
        label.setForeground(Color.BLACK);
        patient.setFont(new java.awt.Font("Segoe UI", 0, 24));patient.setBounds(150, 110, 330, 36);
        diagnosis.setFont(new java.awt.Font("Segoe UI", 0, 24));diagnosis.setBounds(150, 180, 330, 40);
        history.setFont(new java.awt.Font("Segoe UI", 0, 24));history.setBounds(150, 260, 330, 40);
        bill.setFont(new java.awt.Font("Segoe UI", 0, 24));bill.setBounds(150, 340, 330, 40);
        credits.setFont(new java.awt.Font("Segoe UI", 0, 24));credits.setBounds(150, 420, 330, 39);
        exit.setFont(new java.awt.Font("Segoe UI", 0, 24));exit.setBounds(150, 500, 330, 39);

        patient.addActionListener(this);patient.setFocusable(false);
        diagnosis.addActionListener(this);diagnosis.setFocusable(false);
        history.addActionListener(this);history.setFocusable(false);
        bill.addActionListener(this);bill.setFocusable(false);
        credits.addActionListener(this);credits.setFocusable(false);
        exit.addActionListener(this);exit.setFocusable(false);
        this.setTitle("Hospital Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(400, 150, 653, 596);
        this.add(label);
        this.add(patient);
        this.add(diagnosis);
        this.add(history);
        this.add(bill);
        this.add(exit);
        this.add(credits);
        this.add(jPanel1);

        this.setVisible(true);
    }
    public static void main(String[] args) {
    new choose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==patient){
            this.dispose();
            new patients();
        }
        if(e.getSource()==diagnosis){
            this.dispose();
            new diagnosis();

        }
        if(e.getSource()==history){
            this.dispose();
            new history1();
        }
        if(e.getSource()==bill){
            this.dispose();
            new bill();
        }
        if(e.getSource()==credits){
            this.dispose();
            new credits();
        }
        if(e.getSource()==exit){
            this.dispose();
        }
    }
}
