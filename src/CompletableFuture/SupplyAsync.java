package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import ThreadPoolExecutor.ThreadPoolExecutorFactory;

public class SupplyAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = ThreadPoolExecutorFactory.getInstance();

        //runs (executor is forkJoinPool default)
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "Hello ";
        });

        //runs (executor is executor)
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "World";
        }, executor);

        String s1 = completableFuture1.get();
        String s2 = completableFuture2.get();
        System.out.println(s1 + s2);

    }
}
