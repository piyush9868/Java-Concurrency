package CustomLocks.reentractLoc2;

import java.util.concurrent.Semaphore;

public class SharedSemaphore {

    boolean isAvailable = false;
    Semaphore semaphore = new Semaphore(2);

    public void producer() {
        //critical section
        try {
            semaphore.acquire();
            System.out.printf("Lock acquired by thread %s\n", Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
            System.out.printf("Lock released by thread %s\n", Thread.currentThread().getName());
        }
    }
}
