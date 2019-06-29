/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bai07;

/**
 *
 * @author duongnguyen
 */
public class ExceptionExample {
    public void testException() {
        //Build-in Exception 
        try {
            
            System.out.println("Line 1");
            int x = 5/0;
            //Connect DB...
            System.out.println("Successful");
        }catch(Exception e) {
            System.out.println("Error = "+e.toString());
        }finally {
            System.out.println("Finally");
        }
    }
    public void testException2() {
        //Create own Exception
        int i = 10;
        try {
            i = i + 1;
            System.out.println("Line 1");
            if(i == 11){
                throw new  Exception("11 la ko duoc");
            }
            //Connect DB...
            System.out.println("Successful");
        }catch(Exception e) {
            System.out.println("Error = "+e.toString());
        }finally {
            System.out.println("Finally");
        }

    }

    public void testException3(int x) {
        //Create own Exception
        try {
            if ((x == 3) || (x == 5) || (x==7)) {
                throw new MyException(MyException.EXCEPTION_ODD_NUMBERS);
              }
            else if(x == -1)
            {
                System.out.println("This is a special number");
            }
             else if ((x == 10) || (x==4)) {
                throw new MyException(MyException.EXCEPTIONNOT_NOT_NUMBER_10);

            }else {
                System.out.println("The number is " + x);

            }

        } catch (Exception e) {
            System.out.println("Error detail: " + e.toString());
        } finally {
            System.out.println("Program ends");
            MyException.showNumberofError();

        }
    }
}
