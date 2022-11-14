package Electricity_billing_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Choice;
import java.awt.event.*;
import java.sql.ResultSet;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class Signup extends JFrame implements ActionListener {
    JButton create,back;
    Choice ac_type;
    JTextField meter,uname,namef;
    JPasswordField p_word;
    Signup(){
         setBounds(450,150,700,400);
         getContentPane().setBackground(Color.white);
         setLayout(null);
 
         JPanel panel= new JPanel();
         panel.setBounds(30,30,650,300);
         panel.setBorder(new TitledBorder(new LineBorder(new Color(128,191,255),3),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(0,51,204)));
         panel.setLayout(null); 
         //panel.setForeground(new Color());
         add(panel);
        
        //Heading
        JLabel heading=new JLabel("Create Account as:");
        heading.setBounds(80,50,180,20);
        heading.setFont(new Font("Aerial",Font.BOLD,14));
        panel.add(heading);

        ac_type =new Choice();
        ac_type.add("Select");
        ac_type.add("Admin");
        ac_type.add("Customer");
        ac_type.setBounds(260,50,200,20);
        panel.add(ac_type);

        //meter
        JLabel meterNo=new JLabel("Meter Number:");
        meterNo.setBounds(80,90,180,20);
        meterNo.setFont(new Font("Aerial",Font.BOLD,14));
        meterNo.setVisible(false);
        panel.add(meterNo);

        meter=new JTextField();
        meter.setBounds(260,90,200,20);
        meter.setVisible(false);
        panel.add(meter);

       

        //username
        JLabel username=new JLabel("Username:");
        username.setBounds(80,130,180,20);
        username.setFont(new Font("Aerial",Font.BOLD,14));
        panel.add(username);

        uname=new JTextField();
        uname.setBounds(260,130,200,20);
        panel.add(uname);

        //name
        JLabel name=new JLabel("Name:");
        name.setBounds(80,170,180,20);
        name.setFont(new Font("Aerial",Font.BOLD,14));
        panel.add(name);

        namef=new JTextField();
        namef.setBounds(260,170,200,20);
        panel.add(namef);
        
        meter.addFocusListener(new FocusListener()
        {   @Override
            public void focusGained(FocusEvent fe ){}
            @Override
            public void focusLost(FocusEvent fe ){
                try {
                    Conn c=new Conn();
                    ResultSet rs= c.s.executeQuery("select *from login where meter_no='"+meter.getText()+"'");
                    
                    while(rs.next()){
                        namef.setText(rs.getString("name"));
                    }
                    
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });
        //Password
        JLabel password=new JLabel("Password:");
        password.setBounds(80,210,180,20);
        password.setFont(new Font("Aerial",Font.BOLD,14));
        panel.add(password);

        p_word=new JPasswordField();
        p_word.setBounds(260,210,200,20);
        panel.add(p_word);


        //
        ac_type.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                String user =ac_type.getSelectedItem();
                if(user.equals("Customer")){
                    meterNo.setVisible(true);
                    meter.setVisible(true);
                    namef.setEditable(false);
                }else{
                    meterNo.setVisible(false);
                    meter.setVisible(false);
                    namef.setEditable(true);
                }
                             }
        });
        
       //create button
       create=new JButton("Create");
       create.setBackground(new Color(0,153,0));
       create.setBounds(80,240,80,20);
       create.addActionListener(this);
       panel.add(create);

       //back button
       back=new JButton("Back");
       back.setBackground(new Color(102,153,153));
       back.setBounds(170,240,80,20);
       back.addActionListener(this);
       panel.add(back);
       
       //image icon
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/signup.jpg"));
       Image i2=i1.getImage().getScaledInstance(160,180,Image.SCALE_DEFAULT );
       ImageIcon i3=new ImageIcon(i2);
       JLabel image =new JLabel(i3);
       image.setBounds(425,30,250,250);
       panel.add(image);
       setVisible(true);
    }     

        //overrideing
        public void actionPerformed(ActionEvent ae)
        {   
            if(ae.getSource()==create){
                String atype= ac_type.getSelectedItem();
                String suname= uname.getText();
                String sname = namef.getText();
                String spassword = String.valueOf(p_word.getPassword());
                String smeter= meter.getText();

                try {//connction
                    Conn c=new Conn();
                    
                    //query generation
                    String query =
                    null;
                    if(ac_type.equals("Admin")) {
                        query="insert into login values('"+smeter+"','" +suname+"','"+sname+"','"+spassword+"','"+atype+"')";
                    }
                    else{
                        query="update login set username='"+suname+"',password='"+spassword+"',user='"+atype+"' where meter_no='"+smeter+"'";
                    }
                    // query execution
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Account Created Successfully");

                    setVisible(false);
                    new Login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(ae.getSource()==back){
                setVisible(false);
                new Login();
            }
            
        }
        
    

    public static void main(String[] args) {
        new Signup();
    }
}
