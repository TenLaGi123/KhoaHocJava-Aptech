/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bai07;


import sun.awt.windows.ThemeReader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 *
 * @author duongnguyen
 */
public class Main {
    
    public static void main(String [] args) {

        ArrayList<Person> persons = new ArrayList<>();
        Person person1 = new Person("Thuan Nguyen", "duong.nguyen13600@gmail.com", 19);
        Person person2 = new Person("Long Hoang", "long.hoang13600@gmail.com", 20);
        Person person3 = new Person("Lonh Nguu", "lung.linh13600@gmail.com", 13);
        Person person4 = new Person("Duc Hai", "duc.long123@gmail.com", 26);
        Person person5 = new Person("Nga Quynh", "ngavu1213@gmail.com", 19);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        Collections.sort(persons, (p1, p2) ->{
            return p2.getAge() - p1.getAge();
        });

        Person person11 = (Person)person1.clone();

        Collections.sort(persons, (p1, p2) ->{
            return p2.getName().compareTo(p1.getName());
        });

        ArrayList<Person> newPersons = (ArrayList<Person>) persons.stream().filter(person -> person.getAge() > 19).
                collect(Collectors.toList());

        ArrayList<Person> filteredPersons = (ArrayList<Person>) persons.stream().
                filter(person -> !person.getEmail().equals("duc.long123@gmail.com")).
                collect(Collectors.toList());
        persons = filteredPersons;
        for(Person person: persons){
            System.out.println(person.toString());

        }


    }
}
