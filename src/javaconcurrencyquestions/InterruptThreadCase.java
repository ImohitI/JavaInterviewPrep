package javaconcurrencyquestions;

public class InterruptThreadCase {
    public static void main(String[] args) {
        Thread taskThread = new Thread (new Task());
        taskThread.start();
        System.out.println("Long running thread");
        for(int i = 0; i < 5000 ; i++){
        }
        taskThread.interrupt();
        System.out.println("Ask nicely");
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            for(int i = 0 ; i < 10000 ; i++){
                //do Something;
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Stopping the task at "+i);
                    return;
                }
            }
        }
    }
}
