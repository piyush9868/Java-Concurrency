package ProducerConsumer;

import java.util.ArrayDeque;
import java.util.Queue;

public class SharedResource {
    Queue<Item> buffer;
    final int MAX_BUFFER_SIZE = 2;

    public SharedResource(int buffer_size) {
        this.buffer = new ArrayDeque<>();
    }

    public synchronized void produce(){
        System.out.printf("Thread %s is ready to produce", Thread.currentThread().getName());
        System.out.println();
        while (buffer.size() == MAX_BUFFER_SIZE){
            try {
                System.out.printf("Thread %s is waiting to be consumed to produce more", Thread.currentThread().getName());
                System.out.println();
                wait();
            }
            catch (Exception e){
                //
            }
        }
        System.out.printf("Thread %s has produced new item", Thread.currentThread().getName());
        System.out.println();
        buffer.offer(new Item());
        notifyAll();
    }

    public synchronized void consume() {
        System.out.println("Consume is called by thread: " + Thread.currentThread().getName());

        while(buffer.isEmpty()){
            try {
                System.out.println("Thread "+ Thread.currentThread().getName() + " is waiting for somebody to produce");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Item is consumed by thread " + Thread.currentThread().getName());
        buffer.poll();
        notifyAll();
    }
}
