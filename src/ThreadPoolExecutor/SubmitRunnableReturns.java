package ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SubmitRunnableReturns {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getInstance();

        //get future object from runnable, throws exception
        List<Integer> lst = new ArrayList<>();
        System.out.println(lst);
        Future<List<Integer>> answer = threadPoolExecutor.submit(new CustomRunnable(lst), lst);
        System.out.println(answer.isDone());
        lst = answer.get();
        System.out.println(lst);
        System.out.println(answer.isDone());
        threadPoolExecutor.shutdown();
    }
}

class CustomRunnable implements Runnable {

    List<Integer> list;

    public CustomRunnable(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.add(0);
    }
}
