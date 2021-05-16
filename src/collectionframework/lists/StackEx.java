package collectionframework.lists;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        /*

        Stack extends Vector
        Stack is base on an object array Object[]

        push(element) ---> add an element at the end of the array
        peek()        ---> retrieve or fetch element of the Stack , the element does not get deleted
        pop()         ---> pop an element from stack


         */
        // Creating an empty Stack
        Stack<Integer> stack = new Stack<Integer>();

        // Use add() method to add elements
        stack.push(10);
        stack.push(15);
        stack.push(30);
        stack.push(20);
        stack.push(5);

        stack.isEmpty();

        // Displaying the Stack
        System.out.println("Initial Stack: " + stack);

        // Removing elements using pop() method
        System.out.println("Popped element: "
                + stack.pop());
        System.out.println("Popped element: "
                + stack.pop());

        // Displaying the Stack after pop operation
        System.out.println("Stack after pop operation "
                + stack);
        int[] queue = {1, 4 , 5};
        int newCapacity = 7;
        queue = Arrays.copyOf(queue, newCapacity);

        System.out.println(queue.length);
        newCapacity = newCapacity >> 1;
        System.out.println(newCapacity);

        int max = Integer.MAX_VALUE;
        max = max + 2;
        //System.out.println(max);
        if(max - Integer.MAX_VALUE > 0 ){
            System.out.println(max);
        }
        if(max < 0){
            System.out.println("max < 0");
        }
        System.out.println(Integer.MIN_VALUE);


        Deque<Integer> de_que = new ArrayDeque<Integer>(10);

        // add() method to insert
        de_que.add(10);
        de_que.add(20);
        de_que.add(30);
        de_que.add(40);
        de_que.add(50);
        for (Integer element : de_que)
        {
            System.out.println("Element : " + element);
        }
        int head = 4;
        head = (head - 1) & (4 - 1);
        System.out.println("head  "+head);

    }

}
