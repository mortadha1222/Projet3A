/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


/**
 *
 * @author ASUS
 */
public interface IRating <R>{
    
    public void ajouterRating(R r);
    public void updateRating(R r , int id);
    public String displayYourRate(int id);
    public String displayRate();
    
}
