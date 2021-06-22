package javaconcurrencyquestions;

import java.util.concurrent.Semaphore;

public class SharedPrinter {

    private Semaphore semEven = new Semaphore(0);
    private Semaphore semOdd = new Semaphore(1);

    void printEvenNum(int num){
        try{
            semEven.acquire();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName()+" <> "+num);
        semOdd.release();
    }

    void printOddNum(int num){
        try{
            semOdd.acquire();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName()+" <> "+num);
        semEven.release();
    }
}
