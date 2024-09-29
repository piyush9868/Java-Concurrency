package ThreadCreation;

public class CreateMain {
    public static void main(String[] args) {

        //via runnable
        System.out.println("-----via runnable------");
        System.out.println("Thread before the custom thread creation is: " + Thread.currentThread().getName());
        MyThreadRunnable myThread = new MyThreadRunnable();
        Thread thread = new Thread(myThread);

        thread.start();
        System.out.println("Program ended. Current thread is: " + Thread.currentThread().getName());

        //via thread
        System.out.println("-----via thread------");
        System.out.println("Thread before the custom thread creation is: " + Thread.currentThread().getName());

        MyThreadViaThread thread2 = new MyThreadViaThread();
        thread2.start();
        System.out.println("Program ended. Current thread is: " + Thread.currentThread().getName());

    }
}
