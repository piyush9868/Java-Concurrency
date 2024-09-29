package deadlockSituation;

public class SharedResourceDL {

    boolean isAvailable = false;
    public synchronized void sharing(){
        System.out.println("Lock is acquired");
        isAvailable = true;

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Lock is released");
    }
}
