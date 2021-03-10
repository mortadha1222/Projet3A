package Tests;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Utils.MyConnection;
import Entities.Planning;
import Entities.Reservation;
import Services.PlanningService;
import Services.ReservationService;

/**
 *
 * @author administrater
 */
public class ClassMain {

    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();

//        
        Planning p = new Planning(3, 20, "rami", "20:22", "20:56", 30);
        PlanningService pcd = new PlanningService();
////        pcd.supprimerPlanning(p);
////                pcd.ajouterPlanning(p);
        pcd.updatePlanning(p);
////        //    System.out.println(pcd.displayPlannings());

//
//      Reservation res= new Reservation(1,20,20);
//    ReservationService rs= new ReservationService();
////     rs.ajouterReservation(res);
////////        rs.supprimerReservation(res);
// System.out.println(rs.displayReservations());
//  
    }
}
