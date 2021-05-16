package collectionframework.lists;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx {
    public static void main(String[] args) {
        // Set demonstration using HashSet
        Set<String> hash_Set = new HashSet<String>();

        hash_Set.add("Geeks");
        hash_Set.add("For");
        hash_Set.add("Geeks");
        hash_Set.add("Example");
        hash_Set.add("Set");

        System.out.println(hash_Set);

        Set<String> treeSet = new TreeSet<>();

        treeSet.add("one");
        treeSet.add("four");
        treeSet.add("two");
        treeSet.add("five");
        treeSet.add("three");

        for(String s : treeSet){
            System.out.println(s); // natural ordering
        }
        double d = 43333.5;
        float f = 4.5f;
        System.out.println(Math.ceil(f));
        System.out.println(Math.floor(5/2));
        System.out.println(Math.sqrt(29));
        Math.round(9);
        int i = (int)Math.ceil(d);
        System.out.println(i);
        double data = 3452.645;
        int value = (int)Math.round(Math.ceil(d));
    }
}
