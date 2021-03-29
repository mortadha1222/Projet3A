/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author splin
 */
public class MyDB {
    private Connection cnx;
    private static MyDB instance;
    private String url = "jdbc:mysql://localhost:3306/work-it";
    
    public MyDB() {
        try {
            cnx = (Connection) DriverManager.getConnection(url, "root", "");
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.err.println("Connexion non établie");
            System.err.println(ex);
        }
        
    }
    public static MyDB getInstance() throws SQLException{
        if ( null != instance)
        {
        } else {
            instance = new MyDB();
            return instance;
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
