/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.users;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.IServiceLogin;
import utils.Maconnexion;

/**
 *
 * @author mortadha
 */
public class ServiceLogin implements IServiceLogin {
       Connection cnx;
   public ServiceLogin(){
   cnx = Maconnexion.getInstance().getConnection();

   }
    @Override
    public boolean Connect(users U) {
           try {
               
               Statement stm = cnx.createStatement();
               String query="select * from `user` where username = '"+U.getUsername()+"' and password = '"+U.getPassword()+"'"; 
               ResultSet rs;
    rs=stm.executeQuery(query);
    users users;
    try {
                   while(rs.next())
                   {
                       users = new users(rs.getString("username"),rs.getString("password"));
                       System.out.println(users); 
                       return true;
                   }          } catch (SQLException ex) {
                   Logger.getLogger(ServiceLogin.class.getName()).log(Level.SEVERE, null, ex);
               }
}          catch (SQLException ex) {
               Logger.getLogger(ServiceLogin.class.getName()).log(Level.SEVERE, null, ex);
           }
return false;
    }}