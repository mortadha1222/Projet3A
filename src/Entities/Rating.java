/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;





/**
 *
 * @author ASUS
 */
public class Rating {
    
    
    int id;
    double value;
    int id_user;

    public Rating(int id, double value, int id_user) {
        this.id = id;
        this.value = value;
        this.id_user = id_user;
    }

    public Rating(double value, int id_user) {
        this.value = value;
        this.id_user = id_user;
    }

    public Rating() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    
    
    
}
