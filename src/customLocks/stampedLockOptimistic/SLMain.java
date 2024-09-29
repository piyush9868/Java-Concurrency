package customLocks.stampedLockOptimistic;

public class SLMain {
    public static void main(String[] args) {
        SLShared slShared = new SLShared();

        Thread th1 = new Thread(()-> {
            slShared.read();
        });


        Thread th2 = new Thread(()-> {
            slShared.write();
        });

        th1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        th2.start();
    }
}
