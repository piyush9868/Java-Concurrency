package customLocks.readWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class RWShared {
    ReadWriteLock readWriteLock;
    private String password;

    RWShared(String password){
        this.password = password;
    }

    public void read(ReadWriteLock readWriteLock){
        try {
            readWriteLock.readLock().lock();
            System.out.printf("Shared Lock acquired by thread: %s\n", Thread.currentThread().getName());
            System.out.printf("Password is: %s\n---- Read by thread %s -----\n", this.password, Thread.currentThread().getName());
            Thread.sleep(4000);
        }
        catch (Exception e){
            //
        }
        finally {
            System.out.printf("Shared Lock released by thread: %s\n", Thread.currentThread().getName());
            readWriteLock.readLock().unlock();
        }
    }

    public void write(ReadWriteLock readWriteLock, String newPassword){
        try {
            readWriteLock.writeLock().lock();
            System.out.printf("Exclusive Lock acquired by thread: %s\n", Thread.currentThread().getName());
            this.password = newPassword;
            System.out.printf("New password is: %s\n---- modified by thread %s -----\n", this.password, Thread.currentThread().getName());
        }
        catch (Exception e){
            //
        }
        finally {
            System.out.printf("Exclusive Lock released by thread: %s\n", Thread.currentThread().getName());
            readWriteLock.writeLock().unlock();
        }
    }
}
