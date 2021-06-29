package javaconcurrencyquestions.producerconsumerdesign;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class TaskProducer extends Thread{
    private boolean blnExit = false;
    private final List<TaskConsumer> consumers;
    private final BlockingQueue<Long> sharedQueue;

    public TaskProducer(final BlockingQueue<Long> sharedQueue , final List<TaskConsumer> consumers){
        this.consumers = consumers;
        this.sharedQueue = sharedQueue;
    }
    public void setExitCondition(final boolean blnDoExit){
        blnExit = blnDoExit;
    }

    @Override
    public void run() {
        long i = 0;
        // producing objects to be consumed
        while(!blnExit){
            try{
                i++;
                sharedQueue.put(Long.valueOf(i));
            }catch(final InterruptedException ex){
                ex.printStackTrace();
            }
        }

        //wait until the queue is empty
        while(sharedQueue.size() > 0){
            try{
                Thread.sleep(200);
                System.out.println("Producer waiting to end.");
            }catch(final InterruptedException e){
                break;
            }
        }

        //send to all consumers the exit condition
        for(final TaskConsumer consumer : consumers){
            consumer.setExitCondition(true);
        }

    }
}
