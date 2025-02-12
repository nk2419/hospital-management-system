import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class info extends JFrame implements ActionListener{
    JButton button;
    info(){

        
        button = new JButton();
        button.setText("NEXT");
        button.setBounds(300,300,100,40);
        button.setFont(new java.awt.Font("Segoe UI", 1, 24));
        button.setFocusable(false);
        button.addActionListener(this);

        button.setBorder(BorderFactory.createEtchedBorder());


        ImageIcon image = new ImageIcon(this.getClass().getResource("/images/hospital building1.jpg"));
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/icon.png"));
        JLabel label=new JLabel();
        label.setText("Hospital Management System");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setFont(new Font("Arial Black", Font.BOLD, 30));
        label.setIconTextGap(-80);
        label.setBounds(0, 0, 700, 500);

        this.setTitle("Hospital Management System");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.add(button);
        this.add(label);
        this.setBounds(400, 150, 700, 500);
        
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            this.dispose();
            new login();

        }
    }
}
