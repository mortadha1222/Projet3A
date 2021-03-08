/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.users;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author mortadha
 */
public interface IServiceUser {
    public void AddUser(users U);
    public void DelUser(users u);
    public void ModUser(users u);
  //  public void SearchUser(users u);
    //public List<users>AfficherUser()throws SQLException;
    
}
