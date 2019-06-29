/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bai07;

import java.util.Scanner;

/**
 *
 * @author duongnguyen
 */
public class Main {
    
    public static void main(String [] args) {
        /*
        ExceptionExample exceptionExample = new ExceptionExample();
        //exceptionExample.testException1();
        exceptionExample.testException2();
        */
        Scanner input = new Scanner(System.in);
        int check;
        do{
            System.out.println("Please enter a number until -1: ");
            check = input.nextInt();
            ExceptionExample exceptionExample = new ExceptionExample();
            exceptionExample.testException3(check);
            MyException.printErrorResult();
        }while(check != -1);


    }
}
