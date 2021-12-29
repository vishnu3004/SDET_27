package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;


/**
 * 
 * @author DELL
 *
 */
public class JavaUtilty {
	/**
	 * It is used to generate random number
	 * @return int data
	 */
	 
      public int getRanDomNumber() {
      Random ran = new Random();
      int intran = ran.nextInt(10000);
      return intran;
      }
     /**
      * used to get System Date and Time in IST  format
      * @return
      */
      public String getSystemDateAndTime() {
    	  Date date = new Date();
    	  return date.toString();
    	  
      }
      /**
       * used to get System date MM/DD/YYYY format
       * @return
       */
      public String getSystemDateWithformate(){
    	  Date date = new Date();
    	  String dateandTime = date.toString();
    	  int MM = date.getMonth()+1;
    	  String DD = dateandTime.split(" ")[2];
    	  String YYYY = dateandTime.split(" ")[5];
    	
    	  
    	  String finalFormate = MM+"/"+DD+"/"+YYYY;
    	  return finalFormate;
    	  
    	  
    	  
      }
}
