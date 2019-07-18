package FrThread;

import testCase.SavingsAccount;

public class ThreadFamiga extends Thread {
    @Override
    public void run() {

        for (int x = 1; x <= 3; x++) {
            System.out.println(x + " Thread name: " + Thread.currentThread().getName());
        }
    }

}
