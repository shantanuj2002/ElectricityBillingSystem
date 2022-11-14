package Electricity_billing_system;

import java.awt.*;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.*;


public class meterInfo extends JFrame implements ActionListener {
JButton next,cancel;
JLabel lblmeter;
Choice meterloc,meter_type,phasecode,bill_type;
String meternumber;
meterInfo(String meternumber){
    this.meternumber=meternumber;
setSize(700,500);
setLocation(400,200);

JPanel p =new JPanel();
p.setLayout(null);
p.setBackground(new Color(173,216,230));
add(p);

JLabel heading= new JLabel("***Meter Information***");
heading.setBounds(100,10,300,25);
heading.setFont(new Font("Tahoma",Font.PLAIN,24));
p.add(heading);

//meter number
JLabel lblname =new JLabel("Meter Number:");
lblname.setBounds(100,80,100,25);
p.add(lblname);

JLabel lblmeternum =new JLabel(meternumber);
lblmeternum.setBounds(240,80,200,20);
p.add(lblmeternum);

//meter location
JLabel lblmeterno =new JLabel("Meter Location:");
lblmeterno.setBounds(100,120,100,20);
p.add(lblmeterno);

meterloc = new Choice();
meterloc.add("Outside");
meterloc.add("Inside");
meterloc.setBounds(240,120,200,20);
p.add(meterloc);

//metertype
JLabel lbladdress =new JLabel("Meter Type:");
lbladdress.setBounds(100,160,100,25);
p.add(lbladdress);

meter_type = new Choice();
meter_type.add("Electric Meter");
meter_type.add("Solar");
meter_type.add("Smart");
meter_type.setBounds(240,160,200,20);
p.add(meter_type);

//phasecode
JLabel lblcity=new JLabel("City:");
lblcity.setBounds(100,200,100,20);
p.add(lblcity);

phasecode = new Choice();
phasecode.add("001");
phasecode.add("002");
phasecode.add("003");
phasecode.add("004");
phasecode.add("005");
phasecode.add("006");
phasecode.add("007");
phasecode.add("008");
phasecode.add("009");
phasecode.setBounds(240,200,200,20);
p.add(phasecode);


//BILL Type
JLabel lblstate=new JLabel("Bill Type:");
lblstate.setBounds(100,240,100,20);
p.add(lblstate);

bill_type = new Choice();
bill_type.add("Household Meter");
bill_type.add("Industrial Meter");
bill_type.setBounds(240,240,200,20);
p.add(bill_type);

//days
JLabel lblemail=new JLabel("Days:");
lblemail.setBounds(100,280,100,20);
p.add(lblemail);

JLabel lbldays=new JLabel("30 Days");
lbldays.setBounds(240,280,100,20);
p.add(lbldays);

//Phone number
JLabel lblphone=new JLabel("Note:");
lblphone.setBounds(100,320,100,20);
p.add(lblphone);

JLabel lblphones=new JLabel("By Default is calculated for 30 days");
lblphones.setBounds(240,320,200,20);
p.add(lblphones);

//Button submit
next =new JButton("Submit");
next.setBounds(180,390,100,25);
next.setBackground(Color.white);
next.addActionListener(this);
p.add(next);


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
         String meter =meternumber;
         String location =meterloc.getSelectedItem();
         String type =meter_type.getSelectedItem();
         String code =phasecode.getSelectedItem();
         String btype =bill_type.getSelectedItem();
         String days="30";
        

        String query= "insert into meter_info values('"+meter+"', '"+location+"','"+type+"','"+code+"','"+btype+"','"+days+"')";
        
        
         try {
            Conn c=new Conn();
            c.s.executeUpdate(query);
          
            
            JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
            setVisible(false);
            
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
        new meterInfo("");
    }

}
