package producerConsumer;

public class ConsumerRunnable implements Runnable{
    SharedResource sharedResource;

    public ConsumerRunnable(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sharedResource.consume();
    }
}
