package collectionframework.lists;

import java.util.*;

public class HashSetEx {
    public static void main(String[] args) {

        int a = (int) Math.round(3.14); // 3
        int b = (int) Math.round(3.99); // 4
        int c = (int) Math.round(3.5); // 4
        System.out.printf("double : %f, int : %d %n", 3.14, a);
        System.out.printf("double : %f, int : %d %n", 3.99, b);
        System.out.printf("double : %f, int : %d %n", 3.5, c);
        /*

       HashSet permits null value

        HashMap<E,Object> map;
        Object PRESENT = new Object();

        add
            map.put(e, PRESENT)==null; // hashmap put returns previous value , if being set for first time , it returns null

        remove(Object o)
            return map.remove(o)==PRESENT;

        contains(Object o)
            map.containsKey(o);




         */
        // Instantiate an object of HashSet
        HashSet<String> hs = new HashSet<String>();

        // Elements are added using add() method
        hs.add("Geek");
        hs.add("For");
        hs.add("Geeks");
        hs.add("A");
        hs.add("B");
        hs.add("Z");

        if(hs.add("A")) {
            System.out.println("A");
        }

        // Iterating though the HashSet
        Iterator itr = hs.iterator();
        while (itr.hasNext())
            System.out.print(itr.next() + ", ");
        System.out.println();

        // Using enhanced for loop
        for (String s : hs)
            System.out.print(s + ", ");
        System.out.println();


        MyObj m1 = new MyObj("A");
        MyObj m2 = new MyObj("A");
        HashSet<MyObj> set = new HashSet<>();
        set.add(m1);
        set.add(m2);

        if(m1.equals(m2)){
            System.out.println("true  ");
        }
        System.out.println(set.size());

        // Instantiate an object of HashSet
        HashSet<ArrayList> listSet = new HashSet<>();

        // create ArrayList list1
        ArrayList<Integer> list1 = new ArrayList<>();

        // create ArrayList list2
        ArrayList<Integer> list2 = new ArrayList<>();

        // Add elements using add method
        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);
        listSet.add(list1);
        listSet.add(list2);

        // print the set size to understand the
        // internal storage of ArrayList in Set
        System.out.println(set.size());

        Set<Gfg> st1;
        st1 = EnumSet.of(Gfg.LEARN, Gfg.CONTRIBUTE);
        System.out.println(st1);


        /*
        LinkedHashSet let us iterate in the order in which they where inserted

         */

        Set<String> lh = new LinkedHashSet<String>();

        // Adding elements into the LinkedHashSet
        // using add()
        lh.add("India");
        lh.add("Australia");
        lh.add("South Africa");

        // Adding the duplicate
        // element
        lh.add("India");

        // Displaying the LinkedHashSet
        System.out.println(lh);

        // Removing items from LinkedHashSet
        // using remove()
        lh.remove("Australia");
        System.out.println("Set after removing "
                + "Australia:" + lh);

        // Iterating over linked hash set items
        System.out.println("Iterating over set:");
        Iterator<String> i = lh.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }
}
enum Gfg { CODE, LEARN, CONTRIBUTE, QUIZ, MCQ }
;
class MyObj{
    String name ;
    public MyObj(String name){
        this.name = name;
    }
/*
overriding equals method
first check equality ==
check instanceof
the add custom equal logic

important to also override hashcode
equal objects should have same hashcode
 */
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof MyObj)){
            return false;
        }
        MyObj m = (MyObj)obj;
        return name.equals(m.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
