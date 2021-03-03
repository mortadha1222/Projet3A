/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



/**
 *
 * @author mortadha
 */
public class users {
    private int id_user,telephone;
    private String username,password,first_name,last_name,adresse,email;

 
    public users(int id_user, int telephone, String username, String password, String first_name, String last_name, String adresse, String email) {
        this.id_user = id_user;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.adresse = adresse;
        this.email = email;
    }
        public users(int telephone, String username, String password, String first_name, String last_name, String adresse, String email) {
     //   this.id_user = id_user;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.adresse = adresse;
        this.email = email;
    }

   public users() {
        
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_user() {
        return id_user;
    }

    public int getTel() {
        return telephone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFname() {
        return first_name;
    }

    public String getLname() {
        return last_name;
    }


    public String getAdress() {
        return adresse;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setTel(int tel) {
        this.telephone = telephone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFname(String first_name) {
        this.first_name = first_name;
    }

    public void setLname(String last_name) {
        this.last_name = last_name;
    }


    public void setAdress(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "users{" + "id_user=" + id_user + ", telephone=" + telephone + ", username=" + username + ", password=" + password + ", first_name=" + first_name + ", last_name=" + last_name + ", adresse=" + adresse + ",email=" + email + '}';
    }
    
}
