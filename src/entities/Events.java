/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Events {

    public Events(String name_eve, String date_eve, String description_eve, String photo_eve) {
        this.name_eve = name_eve;
        this.date_eve = date_eve;
        this.description_eve = description_eve;
        this.photo_eve = photo_eve;
    }

    public Events(int id_event, String name_eve, String date_eve, String description_eve, String photo_eve) {
        this.id_event = id_event;
        this.name_eve = name_eve;
        this.date_eve = date_eve;
        this.description_eve = description_eve;
        this.photo_eve = photo_eve;
    }

    public Events(String name_eve, String date_eve, String description_eve, String photo_eve, int id_member) {
        this.name_eve = name_eve;
        this.date_eve = date_eve;
        this.description_eve = description_eve;
        this.photo_eve = photo_eve;
        this.id_member = id_member;
    }
    private int id_event;
    private String name_eve;
    private String date_eve;
    private String description_eve;
    private String photo_eve;
    private int id_member;

    public Events(int id_event, String name_eve, String date_eve, String description_eve, String photo_eve, int id_member) {
        this.id_event = id_event;
        this.name_eve = name_eve;
        this.date_eve = date_eve;
        this.description_eve = description_eve;
        this.photo_eve = photo_eve;
        this.id_member = id_member;
    }

    public Events() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }





    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setName_eve(String name_eve) {
        this.name_eve = name_eve;
    }

    public void setDate_eve(String date_eve) {
        this.date_eve = date_eve;
    }

    public void setDescription_eve(String description_eve) {
        this.description_eve = description_eve;
    }

    public void setPhoto_eve(String photo_eve) {
        this.photo_eve = photo_eve;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    public int getId_event() {
        return id_event;
    }

    @Override
    public String toString() {
        return "Events{" + "date_eve=" + date_eve + '}';
    }


    public  String getName_eve() {
        return name_eve;
    }

    public String getDate_eve() {
        return date_eve;
    }

    public String getDescription_eve() {
        return description_eve;
    }

    public String getPhoto_eve() {
        return photo_eve;
    }

    public int getId_member() {
        return id_member;
    }

}
