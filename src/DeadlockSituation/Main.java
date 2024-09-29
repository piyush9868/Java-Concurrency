package DeadlockSituation;

public class Main {
    public static void main(String[] args) {
        SharedResourceDL sharedResourceDL = new SharedResourceDL();
        Thread th1 = new Thread(() -> {
            sharedResourceDL.sharing();
        });

        Thread th2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            }
            catch (Exception e){
                //
            }
            System.out.println("Thread 2 will now try to enter te shared resource");
            sharedResourceDL.sharing();
        });

        th1.start();
        th2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        th1.resume();
    }
}
