package javaconcurrencyquestions.threadpooldesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new PotatoPeelingTask(3),
                new PotatoPeelingTask(6),
                new CoffeeMakingTask(2),
                new CoffeeMakingTask(6),
                new PotatoPeelingTask(4),
                new CoffeeMakingTask(2),
                new PotatoPeelingTask(4),
                new CoffeeMakingTask(9),
                new PotatoPeelingTask(3),
                new CoffeeMakingTask(2),
                new PotatoPeelingTask(4),
                new CoffeeMakingTask(2),
                new CoffeeMakingTask(7),
                new PotatoPeelingTask(4),
                new PotatoPeelingTask(5));

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(Task task : tasks){
            Worker worker = new Worker(task);
            executorService.execute(worker);
        }
        executorService.shutdown();

        while(!executorService.isTerminated()){
            Thread.yield();
        }
        System.out.println("Program Finished");
    }

}
