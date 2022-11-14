package Electricity_billing_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener{
    JButton login,signup,cancel;
    JTextField fusername;
    JPasswordField fpassword;
    Choice floginin;
    Login(){
            super("Login Page");
            getContentPane().setBackground(Color.white);
            setLayout(null);

            //Username
            JLabel username=new JLabel("Username:");
            username.setBounds(300,20,100,20);
            // username.setFont(new Font("Verdana", Font.  PLAIN, 8));
            add(username);
            fusername =new JTextField();
            fusername.setBounds(400, 20, 150, 25);
            add(fusername);

            //Password
            JLabel password=new JLabel("Password:");
            password.setBounds(300,50,100,20);
            add(password);
            fpassword =new JPasswordField();
            fpassword.setBounds(400, 50, 150, 25);
            add(fpassword);

            //Login as customer or admin
            JLabel loginas=new JLabel("Login as:");
            loginas.setBounds(300,80,100,20);
            add(loginas);

            floginin=new Choice();
            floginin.add("(Select)");
            floginin.add("Admin");
            floginin.add("Customer");
            floginin.setBounds(400,80,150,20);
            add(floginin);

            //Login button
            login=new JButton("Login");
            login.setBackground(Color.GREEN);
            login.setContentAreaFilled(false);
            login.setOpaque(true);
            login.setBounds(300,120,80,20);
            login.addActionListener(this);
            add(login);

            //cancel button
            cancel=new JButton("Cancel");
            cancel.setBackground(Color.RED);
            cancel.setBounds(400,120,80,20);
            cancel.addActionListener(this);
            add(cancel);


            //signup button
            signup=new JButton("Signup");
            signup.setBackground(Color.GRAY);
            signup.setContentAreaFilled(false);
            signup.setOpaque(true);
            signup.setBounds(340,160,100,20);
            signup.addActionListener(this);
            add(signup);

            //Image icon
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/login.jpg"));
            Image i2= i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
            ImageIcon i3 =new ImageIcon(i2);
            JLabel image =new JLabel(i3);
            image.setBounds(0,0,250,250);
            add(image);

            setSize(640,300);
            setLocation(400,200);
            setVisible(true);

    }
    //override
    public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==login){
            String susername = fusername.getText();
            String spassword = String.valueOf(fpassword.getPassword());
            String user= floginin.getSelectedItem();
            try {
                Conn c=new Conn();
                String query ="select *from login where username ='"+susername+"' and password='"+spassword+"' and user='"+user+"'";

                ResultSet rs= c.s.executeQuery(query);

                if(rs.next()){
                    String meter=rs.getString("meter_no");
                     setVisible(false);
                     new Project(user,meter);
                }
               else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                fusername.setText("");
                fpassword.setText("");
                
               }
            } catch (Exception e) {
                
                e.printStackTrace();
            }
          }
          else if(ae.getSource()==signup){
              setVisible(false);
              new Signup();

          }
          else if(ae.getSource()==cancel){
               setVisible(false);
         }

    }
    public static void main(String[] args) {
        new Login();

    }
   
    
}
