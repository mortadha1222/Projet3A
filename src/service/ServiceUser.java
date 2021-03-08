/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.IServiceUser;
import utils.Maconnexion;

/**
 *
 * @author mortadha
 */
public class ServiceUser implements IServiceUser {
   Connection cnx;
   public ServiceUser(){
   cnx = Maconnexion.getInstance().getConnection();
   }

    @Override
    public void AddUser(users U) {
        System.out.println(U);
            try {
           Statement stm=cnx.createStatement();
           String query="INSERT INTO user(username,password,first_name,last_name,adresse,telephone,email) VALUES ('"+U.getUsername()+"','"+U.getPassword()+"','"+U.getFname()+"','"+U.getLname()+"','"+U.getAdress()+"','"+U.getTel()+"','"+U.getEmail()+"')";
           //String query="insert into "
      
           stm.executeUpdate(query);
            } catch (SQLException ex) {
           Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
public ObservableList<users> getUsersList() throws SQLException{
    ObservableList<users> usersList= FXCollections.observableArrayList();
    Statement stm = cnx.createStatement();
    String query="select * from `user`";
    ResultSet rs;
    rs=stm.executeQuery(query);
    users users;
    while(rs.next())
    {
 users = new users(rs.getInt("id_user"),rs.getInt("telephone"),rs.getString("username"),rs.getString("password"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("adresse"),rs.getString("email"));  
System.out.println(users);
usersList.add(users);

    }
    return usersList;
}

   /* @Override
    public List<users> AfficherUser()throws SQLException { 
      
       Statement stm = cnx.createStatement();
       String query="select * from `user`";
       ResultSet rst=stm.executeQuery(query);
       List<users>userrs=new ArrayList<>();
       while(rst.next())
       {
           users u= new users();
           u.setId_user(rst.getInt("id_user"));
           u.setUsername(rst.getString("username"));
           u.setPassword(rst.getString("password"));
           u.setFname(rst.getString("first_name"));
           u.setLname(rst.getString("last_name"));
           
           u.setAdress(rst.getString("adresse"));
           u.setTel(rst.getInt("telephone"));
           
          // u.setBdate(rst.getString("birth_date"));
          // u.setImage(rst.getString("photo"));
           u.setEmail(rst.getString("email"));
           userrs.add(u);
       }

        return userrs;
    }*/

    @Override
    public void DelUser(users u) {
       try {
            Statement stm=cnx.createStatement();
            String query="delete from `user` where `id_user` = "+u.getId_user()+"";
            stm.executeUpdate(query);
            
       } catch (SQLException ex) {
           Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    public void ModUser(users u) {
                try {
            Statement stm = cnx.createStatement();
              String query = "UPDATE  user  set username = '"+u.getUsername()+"', password = '"+u.getPassword()+"', first_name = '"+u.getFname()+"', last_name = '"+u.getLname()+"', adresse = '"+u.getAdress()+"', telephone = '"+u.getTel()+"', email = '"+u.getEmail()+"' WHERE id_user = "+u.getId_user()+";";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   /* @Override
    public void SearchUser(users u) {
       try {
           Statement stm = cnx.createStatement();
           String query="select * from user where first_name = '"+u.getFname()+"'";
           stm.executeQuery(query);
       } catch (SQLException ex) {
           Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }*/
public ObservableList<users> SearchUsersList(users u) throws SQLException{
    ObservableList<users> SusersList= FXCollections.observableArrayList();
    Statement stm = cnx.createStatement();
    //users u = new users();
    String query = "select * from `user` where first_name = '"+u.getFname()+"'";
    ResultSet rs;
    rs=stm.executeQuery(query);
    users users;
    while(rs.next())
    {
 users = new users(rs.getInt("id_user"),rs.getInt("telephone"),rs.getString("username"),rs.getString("password"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("adresse"),rs.getString("email"));  
System.out.println(users);
SusersList.add(users);

    }
    return SusersList;
}
public ObservableList<users> UpUsersList() throws SQLException{
    ObservableList<users> SusersList= FXCollections.observableArrayList();
    Statement stm = cnx.createStatement();
    String query = "select * from `user` order by id_user asc";
    ResultSet rs;
    rs=stm.executeQuery(query);
    users users;
    while(rs.next())
    {
 users = new users(rs.getInt("id_user"),rs.getInt("telephone"),rs.getString("username"),rs.getString("password"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("adresse"),rs.getString("email"));  
System.out.println(users);
SusersList.add(users);

    }
    return SusersList;
}
public ObservableList<users> DownUsersList() throws SQLException{
    ObservableList<users> SusersList= FXCollections.observableArrayList();
    Statement stm = cnx.createStatement();
    String query = "select * from `user` order by id_user desc";
    ResultSet rs;
    rs=stm.executeQuery(query);
    users users;
    while(rs.next())
    {
 users = new users(rs.getInt("id_user"),rs.getInt("telephone"),rs.getString("username"),rs.getString("password"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("adresse"),rs.getString("email"));  
System.out.println(users);
SusersList.add(users);

    }
    return SusersList;
}
}


