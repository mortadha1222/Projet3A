/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author administrater
 */
public class Reservation {
    private int id_reservation; 
      private int id_planning; 
    private int id_member;
    private int id_coach;

    public Reservation(int id_reservation, int id_planning, int id_member, int id_coach) {
        this.id_reservation = id_reservation;
        this.id_planning = id_planning;
        this.id_member = id_member;
        this.id_coach = id_coach;
    }

    public Reservation(int id_planning, int id_member, int id_coach) {
        this.id_planning = id_planning;
        this.id_member = id_member;
        this.id_coach = id_coach;
    }

    public Reservation(int id_planning) {
        this.id_planning = id_planning;
    }
    

    public Reservation() {
    }
    

    public int getId_reservation() {
        return id_reservation;
    }

    public int getId_planning() {
        return id_planning;
    }

    public int getId_member() {
        return id_member;
    }

    public int getId_coach() {
        return id_coach;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public void setId_planning(int id_planning) {
        this.id_planning = id_planning;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    public void setId_coach(int id_coach) {
        this.id_coach = id_coach;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_reservation=" + id_reservation + ", id_planning=" + id_planning + ", id_member=" + id_member + ", id_coach=" + id_coach + '}';
    }

   
    
    
}
