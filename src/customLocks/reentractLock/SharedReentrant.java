package customLocks.reentractLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedReentrant {

    boolean isAvailable = false;
    ReentrantLock reentrantLock;

    public void producer(ReentrantLock reentrantLock) {
        System.out.printf("Thread %s entered producer\n", Thread.currentThread().getName());
        //critical section
        try {
            reentrantLock.lock();
            System.out.printf("Lock acquired by thread %s\n", Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
            System.out.printf("Lock released by thread %s\n", Thread.currentThread().getName());
        }
        System.out.printf("Thread %s exit producer\n", Thread.currentThread().getName());

    }
}
