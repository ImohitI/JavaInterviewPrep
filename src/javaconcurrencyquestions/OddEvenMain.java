package javaconcurrencyquestions;

public class OddEvenMain {
    /*

     */
    public static void main(String[] args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print , 10 , false), "Odd");
        Thread t2 = new Thread(new TaskEvenOdd(print , 10 , true), "Even");

        t1.start();
        t2.start();


/*        System.out.println("----Using Semaphore-----");

        SharedPrinter sp = new SharedPrinter();
        Thread odd = new Thread(new Odd(sp, 10),"Odd");
        Thread even = new Thread(new Even(sp, 10),"Even");
        odd.start();
        even.start();*/

    }
}
