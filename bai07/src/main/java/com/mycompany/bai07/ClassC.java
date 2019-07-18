package com.mycompany.bai07;

import java.util.ArrayList;

public class ClassC {
    private ArrayList<Thread> previousThreads = new ArrayList<>();
    public void doTaskC(){
        System.out.println("I start doing C");
    }

    public void addThread(Thread thread){
        previousThreads.add(thread);
    }

    public void removeThread(Thread thread){
        previousThreads.remove(thread);
    }

    public void clearThread(){
        previousThreads.clear();
    }

    public Boolean isFinished(){
        int count = 0;
        for (Thread thread: previousThreads) {
            if(thread instanceof Thread1 || thread instanceof Thread2) {
                count++;
            }

            if(count == 2){
                return true;
            }
        }

        return false;
    }
}
