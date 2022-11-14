package Electricity_billing_system;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash()
    {   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/splash.jpg"));
        Image i2 =i1.getImage().getScaledInstance(500, 500,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        setVisible(true);
        int x=1;

        for(int i=2;i<500;i+=4,x+=0.8){
            setSize(i+x,i);
            setLocation(700-((i+x)/2),400-(i/2));
            try{
                 Thread.sleep(5);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        t=new Thread(this);
        t.start();
        setVisible(true);
       
    }
    public void run(){
           try{
              Thread.sleep(2000);
              setVisible(false);

              //login screen
              new Login();
           } catch(Exception e){
            e.printStackTrace();
           }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
