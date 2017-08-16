package com.gft.GiFT.projects.cycleSnapsAdd;
import java.text.DecimalFormat;

public class WasteMeasure {
  public static String   wasteCalculation(int teamCapacity,int wasteDays, boolean isWasteAvailable){

      String wastePercentString="";
      if(isWasteAvailable!=false) {
         DecimalFormat df = new DecimalFormat("#.00");

          double wastePercent = ((double)(wasteDays / (double)teamCapacity));
          wastePercent= wastePercent*100;
          double roundOff = (double) Math.round(wastePercent * 100) / 100;
          wastePercentString = Double.toString(roundOff);
          return wastePercentString+"%";
      }

      else{
          wastePercentString= "No data";
          return  wastePercentString;
      }
    }
}
