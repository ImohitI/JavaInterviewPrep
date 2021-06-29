package javaconcurrencyquestions.blockingqueueImpl;

import java.util.Deque;
import java.util.LinkedList;

public class JavaBoundedBlockingQueue {

    Deque<Integer> deQueue;
    int size;
    Object lock;

    public JavaBoundedBlockingQueue(int capacity){
        deQueue = new LinkedList<>();
        size = capacity;
        lock = new Object();
    }

    // When queue is full , block enqueue thread
    // add thread to full waiting list
    public void enqueue(int element) throws InterruptedException{
        synchronized (lock){
            while(deQueue.size() == size){
                lock.wait();
            }
            deQueue.addLast(element);
            System.out.println("adding value "+element);
            lock.notify();
        }
    }

    //When queue is empty, we block dequeue thread
    //and add thread to empty waiting list
    public int dequeue() throws InterruptedException {
        int val = 0;
        synchronized (lock){
            while(deQueue.isEmpty()){
                lock.wait();
            }
            val = deQueue.removeFirst();
            System.out.println("removing value "+val);
            lock.notify();
        }
        return val;
    }

    public static void main(String[] args) throws InterruptedException {

        JavaBoundedBlockingQueue q = new JavaBoundedBlockingQueue(3);
        /*
        boundedBlockingQueue.enqueue(1);
        boundedBlockingQueue.dequeue();
        boundedBlockingQueue.dequeue();
        boundedBlockingQueue.enqueue(0);
        boundedBlockingQueue.enqueue(2);
        boundedBlockingQueue.enqueue(3);
        boundedBlockingQueue.enqueue(4);
        */
        Thread thread1 = new Thread(new Thread1(q));
        Thread thread2 = new Thread(new Thread2(q));

        thread1.start();
        thread2.start();

    }
}
class Thread1 implements Runnable{
    JavaBoundedBlockingQueue q;

    @Override
    public void run() {
        try{
            q.enqueue(1);
            q.dequeue();
            q.dequeue();
            q.enqueue(4);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

    }

    public Thread1(JavaBoundedBlockingQueue q) {
        this.q = q;

    }

}
class Thread2 implements Runnable{
    JavaBoundedBlockingQueue q;

    @Override
    public void run() {
        try{
            q.enqueue(0);
            q.enqueue(2);
            q.enqueue(3);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

    }

    public Thread2(JavaBoundedBlockingQueue q) {
        this.q = q;

    }

}
