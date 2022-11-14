package Electricity_billing_system;

import java.awt.*;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;


public class NewCustomer extends JFrame implements ActionListener {
JTextField tfname,tfaddress,tfcity,tfstate,tfemail,tfphone;
JButton next,cancel;
JLabel lblmeter;
NewCustomer(){
setSize(700,500);
setLocation(400,200);

JPanel p =new JPanel();
p.setLayout(null);
p.setBackground(new Color(173,216,230));
add(p);

JLabel heading= new JLabel("New Customer");
heading.setBounds(180,10,200,25);
heading.setFont(new Font("Tahoma",Font.PLAIN,24));
p.add(heading);

//customer name
JLabel lblname =new JLabel("Customer Name:");
lblname.setBounds(100,80,100,25);
p.add(lblname);

tfname =new JTextField();
tfname.setBounds(240,80,200,20);
p.add(tfname);

//meter number 
JLabel lblmeterno =new JLabel("Meter No:");
lblmeterno.setBounds(100,120,100,20);
p.add(lblmeterno);

lblmeter = new JLabel("");
lblmeter.setBounds(240,120,100,20);
p.add(lblmeter);

Random ran=new Random();
long number=ran.nextLong()%1000000;
lblmeter.setText("" +Math.abs(number));

//address
JLabel lbladdress =new JLabel("Address:");
lbladdress.setBounds(100,160,100,25);
p.add(lbladdress);

tfaddress =new JTextField();
tfaddress.setBounds(240,160,200,20);
p.add(tfaddress);

//city 
JLabel lblcity=new JLabel("City:");
lblcity.setBounds(100,200,100,20);
p.add(lblcity);

tfcity =new JTextField();
tfcity.setBounds(240,200,200,20);
p.add(tfcity);

//state 
JLabel lblstate=new JLabel("State:");
lblstate.setBounds(100,240,100,20);
p.add(lblstate);

tfstate=new JTextField();
tfstate.setBounds(240,240,200,20);
p.add(tfstate);

//email
JLabel lblemail=new JLabel("Email:");
lblemail.setBounds(100,280,100,20);
p.add(lblemail);

tfemail = new JTextField();
tfemail.setBounds(240,280,200,20);
p.add(tfemail);

//Phone number
JLabel lblphone=new JLabel("Phone Number:");
lblphone.setBounds(100,320,100,20);
p.add(lblphone);

tfphone=new JTextField();
tfphone.setBounds(240,320,200,20);
p.add(tfphone);

//Button next
next =new JButton("Next");
next.setBounds(130,390,100,25);
next.setBackground(Color.white);
next.addActionListener(this);
p.add(next);

//Button cancel
cancel =new JButton("Cancel");
cancel.setBounds(260,390,100,25);
cancel.setBackground(Color.RED);
cancel.addActionListener(this);
p.add(cancel);

BorderLayout layout=new BorderLayout();
setLayout(layout);
add(p,BorderLayout.CENTER);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/hicon1.jpg"));
Image image =i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
ImageIcon i2= new ImageIcon(image);
JLabel image2 =new JLabel(i2);
add(image2,BorderLayout.WEST);

getContentPane().setBackground(Color.white);
setVisible(true);
}

//Override
public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==next){
         String name =tfname.getText();
         String meter_no =lblmeter.getText();
         String address =tfaddress.getText();
         String city =tfcity.getText();
         String email =tfemail.getText();
         String state =tfstate.getText();
         String phone =tfphone.getText();

        String query1= "insert into customer values('"+name+"', '"+meter_no+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
        
        String query2="insert into login values('"+meter_no+"',' ','"+name+"',' ',' ')";

         try {
            Conn c=new Conn();
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null, "Customer Details added Successfully");
            //setVisible(true);
            setVisible(false);
            
            //new frame
           new meterInfo(meter_no);
         } catch (Exception e) {
            System.out.println("nah");
            e.printStackTrace();
         }
    }
    else{
        setVisible(false);
    }
    
 }

    public static void main(String[] args) {
        new NewCustomer();
    }

}
