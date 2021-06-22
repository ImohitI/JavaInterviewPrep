package javaconcurrencyquestions;

public class TaskEvenOdd implements Runnable{

    /*
    Two threads are created One for even and one for Odd. A single print object is passed into
    both threads. Both odd and even methods are synchronized , they use a common volatile variable isOdd.
    When printOdd is called it checks if isOdd flag is true and while it is true we call wait
    since isOdd is initialised to false by default the wait is not called and value is printed.
    We then set the value of isOdd to true, so that thread goes into wait state and call notify to wake up
    the even thread.
     */
    private int max;
    private Printer print;
    private boolean isEvenNumber;

    public TaskEvenOdd(Printer print, int max, boolean isEvenNumber) {
        this.max = max;
        this.print = print;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while(number <= max){
            if(isEvenNumber){
                print.printEven(number);
            }else{
                print.printOdd(number);
            }
            number += 2;
        }
    }
}
