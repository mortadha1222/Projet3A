/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author moham
 */
public class MyConnection {
 
    String url ="jdbc:mysql://localhost:3306/work-it";
    String login ="root";
    String pwd ="";
    Connection cnx;
    static MyConnection instance= null;

    private MyConnection(){
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
