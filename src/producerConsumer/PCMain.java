package producerConsumer;

public class PCMain {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);


        Thread p1 = new Thread(new ProducerRunnable(sharedResource));
        Thread p2 = new Thread(new ProducerRunnable(sharedResource));
        Thread p3 = new Thread(new ProducerRunnable(sharedResource));

        Thread c1 = new Thread(new ConsumerRunnable(sharedResource));
        Thread c2 = new Thread(new ConsumerRunnable(sharedResource));

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
    }
}
