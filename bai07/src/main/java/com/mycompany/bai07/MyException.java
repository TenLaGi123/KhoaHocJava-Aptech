package com.mycompany.bai07;

import java.util.Hashtable;

public class MyException extends Exception {
    private static Integer counter = 0;
    public static Integer EXCEPTION_ODD_NUMBERS = 101;
    public static Integer EXCEPTIONNOT_NOT_NUMBER_10 = 102;
    public Integer errorNumber;
    private static Hashtable <Integer, Integer> errorReport = new Hashtable<>();
 
    public static String getName(Integer errorNumber) {
        if(errorNumber == EXCEPTION_ODD_NUMBERS) {
            return "The number cannot be 3, 5 or 7";
        }
        else if(errorNumber == EXCEPTIONNOT_NOT_NUMBER_10){
            return "The number cannot be 10";
        }
        return "";
    }
    MyException(Integer errorNumber){
        super();
        this.errorNumber = errorNumber;
        
        System.out.println(MyException.getName(this.errorNumber));
        MyException.counter++;
        Integer numberOfThisError = (errorReport.get(this.errorNumber) == null)?1:
                            (errorReport.get(this.errorNumber) +1);
        errorReport.put(this.errorNumber, numberOfThisError);
               
    }

    public static void showNumberofError(){
        System.out.println("Number of errors: " + counter);
    }
    public static void printErrorResult(){
        for(Integer key: errorReport.keySet()) {
            Integer value = errorReport.get(key);
            System.out.print("Error number: "+ key + ", number of appearances; " + value+" ");
            System.out.println(MyException.getName(key));
        }
        
        
    }

}
