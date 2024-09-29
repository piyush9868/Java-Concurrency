package CustomLocks.reentractLoc2;

public class SLMain {
    public static void main(String[] args) {

        SharedSemaphore semaphore = new SharedSemaphore();

        //working on same lock object
        Thread th1 = new Thread(() -> {
            semaphore.producer();
        });
        Thread th2 = new Thread(() -> {
            semaphore.producer();
        });
        Thread th3 = new Thread(() -> {
            semaphore.producer();
        });

        th1.start();
        th2.start();
        th3.start();
    }
}
