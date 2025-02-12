import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;


import javax.swing.*;

public class login extends JFrame implements ActionListener {

    JPasswordField textField;
    JButton reset = new JButton( "Reset");
    JButton loginbut = new JButton( "Login");
    main m = new main();

    login(){
        textField = new JPasswordField();
        textField.setBounds(80, 50, 150, 30);

        reset.setBounds(190, 90, 100, 25);
        reset.setFocusable(false);
        reset.addActionListener(this);

        loginbut.setBounds(60, 90, 100, 25);
        loginbut.setFocusable(false);
        loginbut.addActionListener(this);

        JLabel label = new JLabel();
        label.setText("Enter password to login");
        label.setFont(new Font("MV Boli", Font.BOLD, 20));
        label.setBounds(60, -75, 400, 200);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(550 ,270, 400, 200);
        this.add(label);
        this.add(textField);
        this.add(loginbut);
        this.add(reset);
        
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==reset){
            textField.setText("");
        }
        if(e.getSource()==loginbut){
            String pa = String.valueOf(textField.getPassword());
            String pass = "app";
            if(pa.equals(pass)){
                this.dispose();
                new choose();
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Password", "Error",  JOptionPane.ERROR_MESSAGE);
                textField.setText("");

            }
        }
    }
}
