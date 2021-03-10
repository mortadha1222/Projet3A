/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author administrater
 */
public interface IPlanning <T>{
    
    public void ajouterPlanning(T t);
    public void supprimerPlanning(T t);
    public void updatePlanning(T t);
    public List<T> displayPlannings();
    
}
