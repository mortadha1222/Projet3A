/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Administrator
 */
public class Actualities {

    public Actualities(int id_act, String title_act, String date_act, String description_act, String photo_act, int id_member) {
        this.id_act = id_act;
        this.title_act = title_act;
        this.date_act = date_act;
        this.description_act = description_act;
        this.photo_act = photo_act;
        this.id_member = id_member;
    }
    private int id_act;
    private String title_act;

    public void setId_act(int id_act) {
        this.id_act = id_act;
    }

    public void setTitle_act(String title_act) {
        this.title_act = title_act;
    }

    public void setDate_act(String date_act) {
        this.date_act = date_act;
    }

    public void setDescription_act(String description_act) {
        this.description_act = description_act;
    }

    public void setPhoto_act(String photo_act) {
        this.photo_act = photo_act;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }
    private String date_act;
    private String description_act;
    private String photo_act;
    private int id_member;

    public Actualities(String name_act, String date_act, String description_act, String photo_act, int id_member) {
        this.title_act = name_act;
        this.date_act = date_act;
        this.description_act = description_act;
        this.photo_act = photo_act;
        this.id_member = id_member;
    }

    public Actualities() {
    }

    @Override
    public String toString() {
        return "Actualities{" + "name_act=" + title_act + ", date_Act=" + date_act + ", description_Act=" + description_act + ", photo_Act=" + photo_act + ", id_Member=" + id_member + '}';
    }

    public int getId_act() {
        return this.id_act;
    }

    public String getName_Act() {
        return this.title_act;
    }

    public String getDate_act() {
        return this.date_act;
    }

    public String getDescription_act() {
        return this.description_act;
    }

    public String getPhoto_act() {
        return this.photo_act;
    }

    public int getId_member() {
        return this.id_member;
    }
}
