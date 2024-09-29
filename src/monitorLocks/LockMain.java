package monitorLocks;

import threadCreation.MyThreadRunnable;

public class LockMain {
    public static void main(String[] args) {

        MonitorLockExample obj1 = new MonitorLockExample();
        MonitorLockExample obj2 = new MonitorLockExample();

        //operating on the same object
        //wil create lock on the object, another thread cant enter same/different synchronized block without lock being released
        RunnableThread rt = new RunnableThread(obj1);
        Thread t1 = new Thread(rt);
        Thread t2 = new Thread(() -> obj1.task2());
        Thread t3 = new Thread(() -> obj1.task3());

        t1.start();
        t2.start();
        t3.start();
    }
}
