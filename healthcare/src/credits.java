import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class credits extends JFrame implements ActionListener{

    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JPanel panel = new JPanel();
    JButton But = new JButton("BACK");
    credits(){

        panel.setBackground(new java.awt.Color(0,0,0));
        panel.setBounds(0, 0, 700, 300);

        But.setBounds(240, 230, 100, 36);
        But.setFocusable(false);
        But.addActionListener(this);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Junaid (RA2211047010136)");
        jLabel2.setBounds(140, 170, 370, 50);

        jLabel3.setFont(new java.awt.Font("Segoe UI",1 , 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Aditva Chauhan (RA2211047010141)");
        jLabel3.setBounds(140, 60, 370, 50);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ananya (RA2211047010139)");
        jLabel4.setBounds(140, 110, 370, 60);
        

        jLabel1.setFont(new java.awt.Font("Arial Black", 2, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Project Made By -->");
        jLabel1.setBounds(150, 20, 392, 35);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(400, 150, 653, 320);
        this.add(But);
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new credits();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        new choose();
    }
    
}
