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
public interface IReservation <T> {
   public void ajouterReservation(T t);
    public void supprimerReservation(T t);
    public void updateReservation(T t);
    public List<T> displayReservations();
}
