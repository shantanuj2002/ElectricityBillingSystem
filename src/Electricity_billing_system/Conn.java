package Electricity_billing_system;

import java.sql.*;


public class Conn {
    Connection c;
    Statement s;
    Conn(){
        //Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","Shantanu@21");
            //System.out.println("connection created");
            s=c.createStatement();
        } catch (SQLException e) {
           // System.out.println("nope");
            e.printStackTrace();
        }
    }
    
}
//Class.forName("com.mysql.jdbc.Driver");