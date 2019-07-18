package com.mycompany.bai07;

public class Thread1 extends Thread {
    private ClassC classC;
    Thread1(ClassC classC) {
        this.classC = classC;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000;i++){
            System.out.print(i);
        }
        System.out.println("\nEnd Thread1");
        classC.finishThread(this);
    }
}
