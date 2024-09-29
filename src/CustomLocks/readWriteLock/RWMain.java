package CustomLocks.readWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWMain {
    public static void main(String[] args) {
        RWShared rwShared = new RWShared("piyush@123");
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

         Thread th1 = new Thread(() -> {
             rwShared.read(readWriteLock);
         });
        Thread th2 = new Thread(() -> {
            rwShared.read(readWriteLock);
        });
        Thread th3 = new Thread(() -> {
            rwShared.write(readWriteLock, "piyush@987");
        });

        //can't write while reading
        th1.start();
        th2.start();
        th3.start();
    }
}
