package javaconcurrencyquestions;

public class Printer {

    private volatile boolean isOdd;

    synchronized void printEven(int number){
        while(!isOdd){
            try{
                System.out.println(Thread.currentThread().getName()+": I am waiting ");

                wait();
            }catch(InterruptedException e){
                System.out.println(Thread.currentThread().getName()+": I am interrupted ");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName()+":"+ number);
        isOdd = false;
        notify();

    }

    synchronized void printOdd(int number){
        while(isOdd){
            try{
                System.out.println(Thread.currentThread().getName()+": I am waiting ");
                wait();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName()+":"+number);
        isOdd = true;
        notify();
    }
}
