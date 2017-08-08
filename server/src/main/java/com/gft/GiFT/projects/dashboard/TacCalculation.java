package com.gft.GiFT.projects.dashboard;


public class TacCalculation {

   public  static String calculateTac(int targetedPoints, int archievedPoints){

    if (targetedPoints == 0 || archievedPoints==0) {
        return "No Data";
    } else {
        int tac = (archievedPoints * 100 / targetedPoints);
        return tac + "%";
    }
}
}
