/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 *
 * @author ASUS
 */
public class Suggestion {
    
         int id,id_user;
     String title,description,answer;
     Date date;

    public Suggestion(int id, String title, String description, String answer, int id_user, Date date) {
        this.id = id;
        this.id_user = id_user;
        this.title = title;
        this.description = description;
        this.answer = answer;
        this.date=date;
    }

    public Suggestion() {
    }

    public Suggestion( String title, String description,int id_user , Date date) {
        this.id_user = id_user;
        this.title = title;
        this.description = description;
        this.date=date;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
     
     
    
}
