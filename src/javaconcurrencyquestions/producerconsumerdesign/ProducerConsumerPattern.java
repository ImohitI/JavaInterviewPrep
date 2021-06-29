package javaconcurrencyquestions.producerconsumerdesign;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerPattern {
    /*
    The Producer / consumer design pattern is a pre-designed solution to seperate the
    two main components by placing a queue in the middle , letting the producer and consumer work in
    different threads.

     */
    private final int queueCapacity = 200;
    private int numbersOfThreads = 10;

    public ProducerConsumerPattern(final int numbersOfThreads){
        if(numbersOfThreads <= 0 || numbersOfThreads > 100){
            throw new IllegalArgumentException("The number of threads be a number between 1 and 100");
        }

        this.numbersOfThreads = numbersOfThreads;

        // Creating shared Object
        final BlockingQueue<Long> sharedQueue = new LinkedBlockingQueue<>();

        // Creating and sharing the Consumer Threads
        final List<TaskConsumer> consumers = new ArrayList<>();
        for(int i = 0 ; i <= this.numbersOfThreads; i++){
            final TaskConsumer consThread = new TaskConsumer(i , sharedQueue);
            consThread.start();
            consumers.add(consThread);
        }

        //Creating and starting the Producer Thread
        final TaskProducer prodThread = new TaskProducer(sharedQueue , consumers);
        prodThread.start();

        try {
            Thread.sleep(1);
            System.out.println("Stop producing");
            prodThread.setExitCondition(true);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ProducerConsumerPattern(20);
    }
}
