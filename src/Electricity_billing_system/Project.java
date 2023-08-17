package Electricity_billing_system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Project extends JFrame implements ActionListener {
    String atype;
    String meter;
    Project(String atype,String meter){
    this.atype=atype;  
    this.meter=meter;
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    //Background Image
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/home123.jpg"));
    Image i2= i1.getImage().getScaledInstance(1550, 850,Image.SCALE_DEFAULT );
    ImageIcon i3=new ImageIcon(i2);
    JLabel image =new JLabel(i3) ; 
    add(image);

    //1.menu bar(master)
    JMenuBar mb=new JMenuBar();
    setJMenuBar(mb);

    JMenu master =new JMenu("Master");
    

            //master menu button (new customer)
            JMenuItem newcustomer =new JMenuItem("New Customer");
            newcustomer.setFont(new Font("Aerial",Font.PLAIN,12));
            newcustomer.setBackground(Color.WHITE);
            ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/icon1.png"));
            Image image2= icon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
            newcustomer.setIcon(new ImageIcon(image2));
            newcustomer.setMnemonic('N');
            newcustomer.addActionListener(this);
            newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
            master.add(newcustomer);
            
            //master menu button (customer_details)
            JMenuItem customer_details =new JMenuItem("Customer Details");
            customer_details.setFont(new Font("Aerial",Font.PLAIN,12));
            customer_details.setBackground(Color.WHITE);
            ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icons/icon2.png"));
            Image image3= icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
            customer_details.setIcon(new ImageIcon(image3));
            customer_details.setMnemonic('D');
            customer_details.addActionListener(this);
            customer_details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
            master.add(customer_details);

            //master menu button (deposit_details)
            JMenuItem deposit_details =new JMenuItem("Deposit Details");
            deposit_details.setFont(new Font("Aerial",Font.PLAIN,12));
            customer_details.setBackground(Color.WHITE);
            ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icons/icon34.png"));
            Image image4= icon3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
            deposit_details.setIcon(new ImageIcon(image4));
            deposit_details.setMnemonic('M');
            deposit_details.addActionListener(this);
            deposit_details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
            master.add(deposit_details);

            //master menu button (calculate_bill)
            JMenuItem calculate_bill =new JMenuItem("Calculate Bill");
            calculate_bill.setFont(new Font("Aerial",Font.PLAIN,12));
            calculate_bill.setBackground(Color.WHITE);
            ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icons/icon4.png"));
            Image image5= icon4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
            calculate_bill.setIcon(new ImageIcon(image5));
            calculate_bill.setMnemonic('C');
            calculate_bill.addActionListener(this);
            calculate_bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
            master.add(calculate_bill);
    
    //2.menu bar(Info)
    JMenu info =new JMenu("Information");
    
    
          //Information menu button (update_info)
          JMenuItem update_info =new JMenuItem("Update Information");
          update_info.setFont(new Font("Aerial",Font.PLAIN,12));
          update_info.setBackground(Color.WHITE);
          ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icons/icon5.png"));
          Image image6= icon5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
          update_info.setIcon(new ImageIcon(image6));
          update_info.setMnemonic('U');
          update_info.addActionListener(this);
          update_info.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
          info.add(update_info);

          //Information menu button (view)
          JMenuItem view =new JMenuItem("View");
          view.setFont(new Font("Aerial",Font.PLAIN,12));
          view.setBackground(Color.WHITE);
          ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icons/icon6.png"));
          Image image7= icon6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
          view.setIcon(new ImageIcon(image7));
          view.setMnemonic('V');
          view.addActionListener(this);
          view.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
          info.add(view);
    
     //3.menu bar(user)
     JMenu user =new JMenu("User");
     

             //User menu button ()
             JMenuItem pay =new JMenuItem("Pay Bill");
             pay.setFont(new Font("Aerial",Font.PLAIN,12));
             pay.setBackground(Color.WHITE);
             ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icons/icon7.png"));
             Image image8= icon7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
             pay.setIcon(new ImageIcon(image8));
             pay.addActionListener(this);
             pay.setMnemonic('P');
             pay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
             user.add(pay);

            //User menu button ()
            JMenuItem bill_details =new JMenuItem("Bill Details");
            bill_details.setFont(new Font("Aerial",Font.PLAIN,12));
            bill_details.setBackground(Color.WHITE);
            ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icons/icon8.png"));
            Image image9= icon8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
            bill_details.setIcon(new ImageIcon(image9));
            bill_details.setMnemonic('B');
            bill_details.addActionListener(this);
            bill_details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
            user.add(bill_details);


     //4.menu bar(report)
     JMenu report =new JMenu("Report");
     

             //report menu button (generate bill)
             JMenuItem generate_bill =new JMenuItem("Generate Bill");
             generate_bill.setFont(new Font("Aerial",Font.PLAIN,12));
             generate_bill.setBackground(Color.WHITE);
             ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icons/icon9.png"));
             Image image10= icon9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
             generate_bill.setIcon(new ImageIcon(image10));
             generate_bill.setMnemonic('G');
             generate_bill.addActionListener(this);
             generate_bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
             report.add(generate_bill);


         //5.menu bar(utility)
         JMenu utility =new JMenu("Utility");


        //utility menu button (notepad)
        JMenuItem notepad =new JMenuItem("Notepad");
        notepad.setFont(new Font("Aerial",Font.PLAIN,12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icons/icon12.png"));
        Image image11= icon10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image11));
        notepad.setMnemonic('G');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        utility.add(notepad);

        //utility menu button (calculator)
         JMenuItem calculator =new JMenuItem("Calculator");
         calculator.setFont(new Font("Aerial",Font.PLAIN,12));
         calculator.setBackground(Color.WHITE);
         ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icons/icon9.png"));
         Image image12= icon11.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
         calculator.setIcon(new ImageIcon(image12));
         calculator.setMnemonic('K');
         calculator.addActionListener(this);
         calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
         utility.add(calculator);

//6.menu bar(exit)
JMenu mexit =new JMenu("Exit");

        //Exit menu button (exit)
        JMenuItem exit =new JMenuItem("Exit");
        exit.setFont(new Font("Aerial",Font.PLAIN,12));
        exit.setBackground(Color.WHITE);
        ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icons/icon11.png"));
        Image image13= icon12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image13));
        exit.setMnemonic('W');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        mexit.add(exit);
        


        //customer separates admin
        if(atype.equals("Admin")){
        mb.add(master);
        }else{
                mb.add(info);
                mb.add(user);
                mb.add(report);
        }
        mb.add(utility);
        mb.add(mexit);

        setLayout(new FlowLayout());
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         String msg=e.getActionCommand();
         if(msg.equals("New Customer")){
                new  NewCustomer();
         }
         else if(msg.equals("Customer Details")){
                new CustomerDetails();
         }
         else if(msg.equals("Deposit Details")){
                new DepositeDetails();
        }
        else if(msg.equals("Calculate Bill")){
                new CalculateBill();
        }
        else if(msg.equals("View")){
                new ViewInformation(meter);
        }
        else if(msg.equals("Update Information")){
                new UpdateInformation(meter);
        }
        else if(msg.equals("Bill Details")){
                new BillDetails(meter);
        }
        else if(msg.equals("Pay Bill")){
                new PayBill(meter);
        }
        else if(msg.equals("Generate Bill")){
                new GenerateBill(meter);
        }
        else if(msg.equals("Notepad")){
                try {
                       // Runtime.getRuntime().exec("notepad.exe");
                       ProcessBuilder pb=new ProcessBuilder("notepad.exe");
                       Process process=pb.start();
                } catch (Exception ep) {
                        // TODO: handle exception
                        ep.printStackTrace();
                }
        }
        else if(msg.equals("Calculator")){
                try {
                       // Runtime.getRuntime().exec("calculator.exe");
                       ProcessBuilder pb=new ProcessBuilder("calc.exe");
                       Process process=pb.start();
                } catch (Exception es) {
                        // TODO: handle exception
                        es.printStackTrace();
                }
        }
        else if(msg.equals("Exit")){
                setVisible(false);
                new Login();
        }
       
    }
    public static void main(String[] args) {
        new Project("","");
    }

}
