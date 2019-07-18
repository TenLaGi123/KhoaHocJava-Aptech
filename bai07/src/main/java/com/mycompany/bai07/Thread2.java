package com.mycompany.bai07;

public class Thread2 extends  Thread {
    private ClassC classC;
    Thread2(ClassC classC) {
        this.classC = classC;
    }
    @Override
    public void run() {
        for(int i = 0; i < 1000;i++){
            System.out.print(i);
        }
        System.out.println("\nEnd Thread2");
        classC.addThread(this);
        if(classC.isFinished()) {
            classC.doTaskC();
        }
    }
}
