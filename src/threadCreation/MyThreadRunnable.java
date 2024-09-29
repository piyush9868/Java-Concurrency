package threadCreation;

//using Runnable interface
public class MyThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("The currenct thread is: " + Thread.currentThread().getName()) ;
    }
}
