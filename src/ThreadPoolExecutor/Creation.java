package ThreadPoolExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Creation {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getInstance();

        for (int i = 1; i <= 6; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("Thread %s is executing its task %s\n", Thread.currentThread().getName(), finalI);
            });
        }
        System.out.println("Shutting down!");
        //shutdown will execute in main thread, but it won't accept new task but all existing tasks will be carried out.
        threadPoolExecutor.shutdown();

    }
}

class CustomThreadFactory implements ThreadFactory {

    AtomicInteger atm = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(Thread.NORM_PRIORITY);
        t.setDaemon(false);
        t.setName("thread-" + atm.getAndIncrement());
        return t;
    }
}

class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(Thread.currentThread().getName() + " was rejected.");
    }
}
