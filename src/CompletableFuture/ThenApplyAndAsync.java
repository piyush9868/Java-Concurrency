package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import ThreadPoolExecutor.ThreadPoolExecutorFactory;

public class ThenApplyAndAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = ThreadPoolExecutorFactory.getInstance();

        //runs in the same thread as
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "Hello ";
        }, executor).thenApplyAsync((String s) -> {
            System.out.println(Thread.currentThread().getName()); // Now should also print thread-1
            return s + "World";
        }, executor);
        executor.shutdown();
    }
}
