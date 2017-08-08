package com.gft.GiFT.projects.dashboard.businessLogic;


public class TacCalculation {

   public  static String calculateTac(int targetedPoints, int achievedPoints){

    if (targetedPoints == 0 || achievedPoints==0) {
        return "No Data";
    } else {
        int tac = (achievedPoints * 100 / targetedPoints);
        return tac + "%";
    }
}
}
