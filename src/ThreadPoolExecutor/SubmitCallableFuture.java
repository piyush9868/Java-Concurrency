package ThreadPoolExecutor;

import java.util.concurrent.*;

public class SubmitCallableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getInstance();

        Future<Float> answer = threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Executing.....");
            return 10f;
        });
        System.out.println(answer.isDone());
        float f = answer.get();
        System.out.println(f);
        System.out.println(answer.isDone());
        threadPoolExecutor.shutdown();
    }
}
