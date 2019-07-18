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
public class Main {
    
    public static void main(String [] args) {
        ClassC classC = new ClassC();
        Thread1 thread1 = new Thread1(classC);
        thread1.start();

        Thread2 thread2 = new Thread2(classC);
        thread2.start();

    }
}
