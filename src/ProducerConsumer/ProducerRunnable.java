package ProducerConsumer;

public class ProducerRunnable implements Runnable{
    SharedResource sharedResource;

    public ProducerRunnable(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.produce();
    }
}
