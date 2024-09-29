package customLocks.reentractLock;

import producerConsumer.SharedResource;

import java.util.concurrent.locks.ReentrantLock;

public class RLMain {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        //working on different shared objects
        SharedReentrant sr1 = new SharedReentrant();
        SharedReentrant sr2 = new SharedReentrant();

        //working on same lock object
        Thread th1 = new Thread(() -> {
            sr1.producer(reentrantLock);
        });
        Thread th2 = new Thread(() -> {
            sr2.producer(reentrantLock);
        });

        th1.start();
        th2.start();
    }
}
