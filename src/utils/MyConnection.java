/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author administrater
 */
public class MyConnection {
    String url ="jdbc:mysql://localhost:3306/work-it-3";
    String login ="root";
    String pwd ="";
    Connection cnx;
    private static MyConnection instance;

    private MyConnection() {
        try {
            cnx = (Connection) DriverManager.getConnection(url,login,pwd);
             
            System.out.println("Connexion établie");  
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        
    }

    public Connection getCnx() {
        return cnx;
    }
    
    public static MyConnection getInstance(){
        if(instance == null){
            instance=new MyConnection();
        }
        return instance;
    }
}
