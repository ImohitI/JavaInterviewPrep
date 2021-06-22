package javaconcurrencyquestions;

public class Even implements Runnable{

    SharedPrinter sharedPrinter;
    int max;

    public Even(SharedPrinter sharedPrinter, int max) {
        this.sharedPrinter = sharedPrinter;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i = 2 ; i <= max ; i = i+ 2){
            sharedPrinter.printEvenNum(i);
        }
    }
}
