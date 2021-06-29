package javaconcurrencyquestions.blockingqueueImpl;

import java.util.concurrent.ArrayBlockingQueue;

public class BQJavaIml {
    public static void main(String[] args) {
        int capacity = 15;
        ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<>(capacity);

        //add numbers
        /*
        Add method cannot insert null and it throws IllegalStateException if the capacity has exceeded
         */
        abq.add(1);
        abq.add(2);
        abq.add(3);

        /*
        add internally calls offer
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (count == items.length)
                return false;
            else {
                enqueue(e);
                return true;
            }
        } finally {
            lock.unlock();
        }
         */

        System.out.println("ArrayBlockingQueue:" +abq);
    }

}
