package ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorFactory {
    private static ThreadPoolExecutor threadPoolExecutor;

    private ThreadPoolExecutorFactory() {

    }

    public static ThreadPoolExecutor getInstance() {
        if (threadPoolExecutor == null) {
            threadPoolExecutor = new ThreadPoolExecutor(3,
                    5,
                    10, TimeUnit.MINUTES,
                    new ArrayBlockingQueue<>(3),
                    new CustomThreadFactory(),
                    new CustomRejectedExecutionHandler()
            );
        }
        return threadPoolExecutor;
    }
}
