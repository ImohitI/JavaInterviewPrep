package collectionframework.lists;

import java.util.Arrays;
import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {

        // Size of the
        // Vector
        int n = 5;

        // Declaring the Vector with
        // initial size n
        Vector<Integer> v = new Vector<Integer>(n);

        // Appending new elements at
        // the end of the vector
        for (int i = 1; i <= n; i++)
            v.add(i);

        // Printing elements
        System.out.println(v);

        // Remove element at index 3
        v.remove(3);

        // Displaying the vector
        // after deletion
        System.out.println(v);

        // Printing elements one by one
        for (int i = 0; i < v.size(); i++)
            System.out.print(v.get(i) + " ");

        Object[] elements = new Object[4];
        System.out.println(elements.length);
        Arrays.copyOf(elements , 7);
        //111 --> 11
        System.out.println(elements.length);



    }
}
