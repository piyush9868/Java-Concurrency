package ThreadPoolExecutor;

import java.util.concurrent.*;

public class SubmitRunnableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getInstance();

        //get future object from runnable, throws exception
        Future<?> answer = threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Executing.....");
        });
        System.out.println(answer.isDone());
        answer.get(2L, TimeUnit.SECONDS);
        System.out.println(answer.isDone());
        threadPoolExecutor.shutdown();
    }
}
