
package Electricity_billing_system;

import java.awt.*;
//import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.sql.*;


public class CalculateBill extends JFrame implements ActionListener {
JTextField tfcity,tfstate,tfemail,tfunits;
JButton submit,cancel;
JLabel lblmeter,labeladdress,labelname;
Choice meternumber,cmonth;
CalculateBill(){
setSize(700,500);
setLocation(400,200);

JPanel p =new JPanel();
p.setLayout(null);
p.setBackground(new Color(173,216,230));
add(p);

JLabel heading= new JLabel("Calculate Bill");
heading.setBounds(180,10,200,25);
heading.setFont(new Font("Tahoma",Font.PLAIN,24));
p.add(heading);

//meter number
JLabel lblmeternumber =new JLabel("Meter Number:");
lblmeternumber.setBounds(100,80,100,25);
p.add(lblmeternumber);

meternumber =new Choice();

try {
    Conn c=new Conn();
    ResultSet rs = c.s.executeQuery("select *from customer");
    while(rs.next()){
        meternumber.add(rs.getString("meter_no"));
    }
} catch (Exception e) {
    // TODO: handle exception
    e.printStackTrace();
}
meternumber.setBounds(240,80,200,20);
p.add(meternumber);

//name
JLabel lblname =new JLabel("Name:");
lblname.setBounds(100,120,100,20);
p.add(lblname);

labelname =new JLabel();
labelname.setBounds(240,120,200,20);
p.add(labelname);

//address
JLabel lbladdress =new JLabel("Address:");
lbladdress.setBounds(100,160,100,25);
p.add(lbladdress);

labeladdress =new JLabel();
labeladdress.setBounds(240,160,200,20);
p.add(labeladdress);
try {
    Conn c=new Conn();
    ResultSet rs=c.s.executeQuery("select*from customer where meter_no='"+meternumber.getSelectedItem()+"'");
    while(rs.next()){
          labelname.setText(rs.getString("name"));
          labeladdress.setText(rs.getString("address"));
    }
} catch (Exception e) {
    
    e.printStackTrace();
}

meternumber.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select*from customer where meter_no='"+meternumber.getSelectedItem()+"'");
            while(rs.next()){
                  labelname.setText(rs.getString("name"));
                  labeladdress.setText(rs.getString("address"));
            }
        } catch (Exception et) {
            
            et.printStackTrace();
        }
        
    };
});
//units consumed
JLabel lblcity=new JLabel("Units Consumed:");
lblcity.setBounds(100,200,100,20);
p.add(lblcity);

tfunits =new JTextField();
tfunits.setBounds(240,200,200,20);
p.add(tfunits);

//month
JLabel lblstate=new JLabel("Month:");
lblstate.setBounds(100,240,100,20);
p.add(lblstate);

cmonth=new Choice();
cmonth.setBounds(240,240,200,20);
cmonth.add("January");
cmonth.add("February");
cmonth.add("March");
cmonth.add("April");
cmonth.add("May");
cmonth.add("June");
cmonth.add("July");
cmonth.add("August");
cmonth.add("September");
cmonth.add("October");
cmonth.add("November");
cmonth.add("December");
p.add(cmonth);


//Button submit
submit =new JButton("Submit");
submit.setBounds(130,350,100,25);
submit.setBackground(Color.white);
submit.addActionListener(this);
p.add(submit);

//Button cancel
cancel =new JButton("Cancel");
cancel.setBounds(260,350,100,25);
cancel.setBackground(Color.RED);
cancel.addActionListener(this);
p.add(cancel);

BorderLayout layout=new BorderLayout();
setLayout(layout);
add(p,BorderLayout.CENTER);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/hicon2.jpg"));
Image image =i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
ImageIcon i2= new ImageIcon(image);
JLabel image2 =new JLabel(i2);
add(image2,BorderLayout.WEST);

getContentPane().setBackground(Color.white);
setVisible(true);
}

//Override
public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==submit){
         
         String meter_no =meternumber.getSelectedItem();
         String units= tfunits.getText();
         String month =cmonth.getSelectedItem();
         int totalbill=0;
         
         int units_consumed =Integer.parseInt(units);
         String query = "select * from tax";
         try {
            Conn c=new Conn();
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                totalbill+=units_consumed * Integer.parseInt(rs.getString("meter_rent"));
                totalbill+=  Integer.parseInt(rs.getString("service_tax")) + Integer.parseInt(rs.getString("swacch_bharat_cess")) + Integer.parseInt(rs.getString("fixed_tax"));
            }
        }
            catch (Exception e) {
                e.printStackTrace();
             }
        String query1= "insert into bill values('"+meter_no+"', '"+month+"','"+units+"','"+totalbill+"','Not Paid')";
        try {
            Conn c= new Conn();
            c.s.executeUpdate(query1);
            JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfullty.");
            setVisible(false);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
         
    }
        
    else{
        setVisible(false);
    }
    
 }

    public static void main(String[] args) {
        new CalculateBill();
    }

}
