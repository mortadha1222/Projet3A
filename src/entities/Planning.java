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
public class Planning {

    
    private int id_planning ;
    private int id_coach ;
    private String course;
    private String startLesson;
    private String endLesson;
    private int maxNbr ;

    public Planning(int id_planning, int id_coach, String course, String startLesson, String endLesson, int maxNbr) {
        this.id_planning = id_planning;
        this.id_coach = id_coach;
        this.course = course;
        this.startLesson = startLesson;
        this.endLesson = endLesson;
        this.maxNbr = maxNbr;
    }

    public Planning(int id_coach, String course, String startLesson, String endLesson, int maxNbr) {
        this.id_coach = id_coach;
        this.course = course;
        this.startLesson = startLesson;
        this.endLesson = endLesson;
        this.maxNbr = maxNbr;
    }

    public Planning(String course, String startLesson, String endLesson) {
        this.course = course;
        this.startLesson = startLesson;
        this.endLesson = endLesson;
    }

    
    public Planning(int id_planning) {
        this.id_planning = id_planning;
    }
    
    

    public Planning() {
    }
    

    public int getId_planning() {
        return id_planning;
    }

    public int getId_coach() {
        return id_coach;
    }

    public String getCourse() {
        return course;
    }

    public String getStartLesson() {
        return startLesson;
    }

    public String getEndLesson() {
        return endLesson;
    }

    public int getMaxNbr() {
        return maxNbr;
    }

    public void setId_planning(int id_planning) {
        this.id_planning = id_planning;
    }

    public void setId_coach(int id_coach) {
        this.id_coach = id_coach;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setStartLesson(String startLesson) {
        this.startLesson = startLesson;
    }

    public void setEndLesson(String endLesson) {
        this.endLesson = endLesson;
    }

    public void setMaxNbr(int maxNbr) {
        this.maxNbr = maxNbr;
    }

    @Override
    public String toString() {
        return "Planning{" + "id_planning=" + id_planning + ", id_coach=" + id_coach + ", course=" + course + ", startLesson=" + startLesson + ", endLesson=" + endLesson + ", maxNbr=" + maxNbr + '}';
    }
    
    
    
   
    
}
