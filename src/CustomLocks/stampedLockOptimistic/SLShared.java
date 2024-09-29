package CustomLocks.stampedLockOptimistic;

import java.util.concurrent.locks.StampedLock;

public class SLShared {
    StampedLock stampedLock = new StampedLock();
    private int a = 10;

    public void read() {
        long stamp = stampedLock.tryOptimisticRead();
        try {
            System.out.println("Taken optimistic read");
            a = 11;
            Thread.sleep(4000);
            if(stampedLock.validate(stamp)){
                System.out.println("Value updated");
            }
            else{
                System.out.println("Update failed --rolling back---");
                a = 10;
            }
        } catch (Exception e) {
            //
        }
    }

    public void write() {
        long stamp = stampedLock.writeLock();
        try {
            System.out.println("Performing work");
            a = 9;
        } catch (Exception e) {
            //
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }
}
