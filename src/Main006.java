

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main006 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("A");
        students.add("B");
        students.add("C");

        students.forEach(s -> System.out.println(s));

        //Consumer -- takes input but does not output anything
        Consumer<String> printItem = n -> System.out.println(n);
        students.forEach(printItem);

        //Function -- takes input and output value
        Function<Integer, Integer> doubly = n -> n* n;
        System.out.println(doubly.apply(8));

        //Predicate -- is a lambda expression that returns true or false
        IntPredicate isDivideByThree = n -> n % 3 == 0;
        System.out.println(isDivideByThree.test(3));

        //Supplier -- takes no input but produces an output
        Supplier<Double> randomNumber100 = () -> Math.random() * 100;



        //Stream
        Stream<String> shoppingStream = Stream.of("apples", "banana" , "cherries" , "coffee");

        String[] shoppingArray = new String[]{"apples" , "banana" , "cherries" , "coffee"};
        Stream<String> shoppingArrayStream = Arrays.stream(shoppingArray);

        //Lists
        List<String> shoppingList = Arrays.asList(shoppingArray);
        Stream<String> shoppingListStream = shoppingList.stream();

        //For loop in one line
        shoppingList.stream().forEach(System.out::println);
        shoppingList.parallelStream().forEach(System.out::println);

        //Match
        boolean isOnList = shoppingList.stream().anyMatch(item -> item.contains("apples"));

        //Filter
        Stream<String> itemsInAisle = shoppingList.stream().filter(item -> item.startsWith("c"));

        //Map
        List<Integer> numbersList = Arrays.asList(4 , 2 ,6, 9 , 10 , 17 , 3);
        Stream<Integer> doubleStream = numbersList.stream().map( n -> n*n);

        //Collect
        List<Integer> doubleList = numbersList.stream().map(n -> n*2).collect(Collectors.toList());



        int arr[] = {3, 4 , 2 , 3 , 2 , 3, 1 , 5};
        Map<Integer, Integer> map  = new HashMap<>();

        for(int x : arr){
            if(map.containsKey(x)){
                map.put(x, map.get(x) + 1);
            }else{
                map.put(x , 1);
            }
        }
        int max = Integer.MIN_VALUE;
/*
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(max < entry.getValue()){
                max = entry.getValue();
            }
        }
*/

        for(Integer i : map.values()){
            if(max < i){
                max = i;
            }
        }

        System.out.println(max);

    }
    public static void asa11212method1(){

    }
}
