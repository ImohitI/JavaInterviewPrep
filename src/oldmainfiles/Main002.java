package oldmainfiles;

import java.util.*;
import java.util.stream.Stream;

public class Main002 {
    /*
     * Set       -- A collection that contains no duplicate elements in a set, does not specify order
     * HashSet   -- hashes the element and distributes them into buckets by hash value.
     * TreeSet   -- treeSet is backed by a balanced tree , which makes it ordered and navigable
     *
     *
     */
    public static void main(String[] args) {

        /*
        A set contains no duplicate mean no pair of e1.equals(e2) and at most one null
         */
        Set<String> set = new HashSet<>();
        Set<String> set1 = new LinkedHashSet<>();
        //size, isEmpty , contains , toArray, add , remove , containsAll , addAll , retainAll
        //removeAll , clear , equals , hashCode

        /*
        HashSet           -- implementation of set
        backed by hashMap -- values added as key in HashMap and for value some constant object is used.
        no guarantee of iteration order.

         */

        set.add(new String("A"));
        set.add("A");
        System.out.println(set.size());

        HashSet<ArrayList> hashSet = new HashSet<ArrayList>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);
        hashSet.add(list1);
        hashSet.add(list2);
        System.out.println(list1.equals(list2));
        System.out.println(list1.hashCode() + " " + list2.hashCode() + " " + hashSet.hashCode());
        System.out.println(hashSet.size());

        TreeSet<String> ts = new TreeSet<>();
        /*
        Implementation of SortedSet ,
        uses Tree for storage
        ordering of the element is maintained by a set using their natural ordering
        it does not preserve insertion order, elements are sorted by keys
        The object that are being inserted into tree should be homogeneous and comparable
        TreeSet does not allow to insert Heterogeneous objects.
        An object is comparable if it implements comparable interface
        TreeSet best suitable for storing large amounts of sorted information which are supposed
        to be accessed quickly because of its fast access and retrieval time.
        Its an implementation of a self balancing binary search tree like Red-black tree.
        add remove search is Ologn time. The reason is that in a self balancing tree, it is made
        sure that the height of the tree is always Ologn for all operation.
        operations like printing n elements in the sorted order takes On time.
        Collections.synchronizedSortedSet
         */
        /*
        TreeSet is implementation of NavigableSet based on TreeMap.
        The implementation provides a guaranteed log n time cost for basic operations add , remove and contains

         */




        ts.add("A");
        ts.add("B");
        ts.add("C");

        //duplicate will not get inserted
        ts.add("C");
        System.out.println(ts);
        //ts.add(null); null value not accepted by treeSet

        //accessing elements
        //contains , first , last
        System.out.println(ts.contains("B"));
        System.out.println(ts.first());
        System.out.println(ts.last());
        System.out.println(ts.higher("B"));
        System.out.println(ts.lower("B"));

        ts.add("D");
        ts.add("E");

        //removing
        System.out.println(ts.remove("E"));
        System.out.println(ts.pollLast());
        System.out.println(ts.pollFirst());

        System.out.println("TreeSet  "+ts);

        TreeSet<StringBuffer> ts1
                = new TreeSet<StringBuffer>();

        // Elements are added using add() method
        //ts1.add(new StringBuffer("A"));//java.lang.StringBuffer cannot be cast to java.lang.Comparable
        //ts1.add(new StringBuffer("Z"));
        //ts1.add(new StringBuffer("L"));
        //ts1.add(new StringBuffer("B"));
        //ts1.add(new StringBuffer("O"));

        // We will get RunTimeException :ClassCastException
        // As StringBuffer does not
        // implements Comparable interface
        System.out.println(ts);


        /*
        *
        * Set implementations
        * java.util.EnumSet
        * java.util.HashSet -- backed by HashMap
        * java.util.LinkedHashSet -- guarantees that order of element during iteration is same as they order of insertion
        * java.util.TreeSet -- elements are sorted , order is determined by natural order if they implement Comparable
        *  or by a specific comparator
         */

        //iterate any set using stream api
        Set<String> set2 = new HashSet<>();
        set2.add("one");
        set2.add("two");
        set2.add("three");

        Stream<String> stream = set2.stream();
        stream.forEach((element) -> {System.out.println(element);});

        //converting set to list
        Set<String> set3 = new HashSet<>();
        set.add("123");
        set.add("456");

        List<String> list = new ArrayList<>();
        list.addAll(set3);


        SortedSet sortedSet = new TreeSet();
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        SortedSet sortedSet1 = new TreeSet(comparator);

        //by default the elements are sorted in ascending order
        // for descending  we can use iterator


        Iterator iterator1 = ts.descendingIterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        SortedSet<String> sortedSet2 = new TreeSet<>();
        sortedSet2.add("A");
        sortedSet2.add("B");
        sortedSet2.add("C");
        sortedSet2.add("D");
        //headset
        SortedSet<String> headSet = sortedSet2.headSet("C");
        //tailSet
        SortedSet<String> tailSet = sortedSet2.headSet("D");
        //subSet
        SortedSet<String> subSet  = sortedSet2.subSet("c","e");

        //concurrentModificationException
        //occurs when something we are iterating on is modified
        /*
            List<Integer> integers = newArrayList(1, 2, 3);

            for (Integer integer : integers) {
            integers.remove(1); // concurrentModificationException
            }
         */
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext();) {
            Integer integer = iterator.next();
            if(integer == 2) {
                iterator.remove();
            }
        }




        //equals and hashcode implementation
        //for any non-null reference value a , a.equals(null) should return false.
        // creating the Objects of oldmainfiles.Geek class.
        Geek g1 = new Geek("aa", 1);
        Geek g2 = new Geek("aa", 1);

        // comparing above created Objects.
        if (g1.hashCode() == g2.hashCode()) {

            if (g1.equals(g2))
                System.out.println("Both Objects are equal. ");
            else
                System.out.println("Both Objects are not equal. ");

        } else
            System.out.println("Both Objects are not equal. ");

        //understanding instanceOf
        Child cobj = new Child();

        if (cobj instanceof Child)
            System.out.println("cobj is instance of oldmainfiles.Child");
        else
            System.out.println("cobj is NOT instance of oldmainfiles.Child");

        if (cobj instanceof Parent)
            System.out.println("cobj is instance of oldmainfiles.Parent");
        else
            System.out.println("cobj is NOT instance of oldmainfiles.Parent");

        if (cobj instanceof Object)
            System.out.println("cobj is instance of Object");
        else
            System.out.println("cobj is NOT instance of Object");


        Child obj = null;
        if (obj instanceof Object)
            System.out.println("obj is instance of Object");
        else
            System.out.println("obj is NOT instance of Object");


        Parent pobj = new Parent();
        if (pobj instanceof Child)
            System.out.println("pobj is instance of oldmainfiles.Child");
        else
            System.out.println("pobj is NOT instance of oldmainfiles.Child");

        Parent cobj1 = new Child();
        if (cobj1 instanceof Child)
            System.out.println("cobj1 is instance of oldmainfiles.Child");
        else
            System.out.println("cobj1 is NOT instance of oldmainfiles.Child");

    }
}
class Geek{
    public String name;
    public int id;
    Geek(String name , int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        //checking if both object references are referring to the same object
        if(this == obj){
            return true;
        }

        //checking type
        //checking null
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        //type casting
        Geek geek = (Geek) obj;

        //comparing the state of argument with
        //the state of this object
        return (geek.name == this.name && geek.id == this.id);
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
class Parent{ }
class Child extends Parent{ }

