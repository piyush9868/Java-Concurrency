package threadJoin;

import deadlockSituation.SharedResourceDL;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main Thread is started");
        SharedResourceDL sharedResourceDL = new SharedResourceDL();
        Thread th1 = new Thread(() -> {
            sharedResourceDL.sharing();
        });

        //thread 1 will take 6 seconds. I want main thread to wait before we can resume.

        th1.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main Thread is finished");
    }
}
