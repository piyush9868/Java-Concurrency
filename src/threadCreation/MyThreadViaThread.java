package threadCreation;

//extending the thread class
public class MyThreadViaThread extends Thread{
    @Override
    public void run(){
        System.out.println("The currenct thread is: " + Thread.currentThread().getName()) ;
    }
}
