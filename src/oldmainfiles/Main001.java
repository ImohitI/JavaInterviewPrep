package oldmainfiles;//import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main001 {
    public static void main(String[] args) {

        System.out.println("Hello world");
/*
All methods in List interface
 */
//        List<String> stringList = new ArrayList<>();
//        stringList.size();
//        stringList.isEmpty();
//        stringList.contains(null);
//        Iterator<String> iterator = stringList.iterator();
//        Object[] strings = stringList.toArray();
//        stringList.add(null);
//        stringList.remove(null);
//        stringList.containsAll(new ArrayList<>());
//        stringList.addAll(new ArrayList<>());
//        stringList.addAll(1, new ArrayList<>());
//        stringList.removeAll(new ArrayList<>());
//        stringList.retainAll(new ArrayList<>());
//        stringList.clear();
//        stringList.equals(new Object());
//        stringList.hashCode();
//        stringList.get(0);
//        stringList.set(0, "A");
//        stringList.add(0, "A");
//        stringList.remove(0);
//        stringList.indexOf("A");
//        stringList.lastIndexOf("A");
//        ListIterator<String> listIterator = stringList.listIterator();
//        ListIterator<String> listIterator1 = stringList.listIterator(3);
//        stringList.subList(3, 6);

/*
All default methods in list interface
 */
        List<String> newList = new ArrayList<>();
        newList.add("C");
        newList.add("B");
        newList.add("D");
        newList.add("A");
        newList.replaceAll(s -> s.toLowerCase(Locale.ROOT));
        /*
        Used when a particular action has to be performed on all elements of the list.
        It does not change the type of the list elements. It uses a UnaryOperator.
        UnaryOperator<E> takes single input type E, and returns an output of the same type E.
         */
        System.out.println(newList.toString());

        newList.sort((s1,s2) -> s1.compareTo(s2));

        System.out.println(newList.toString());

/*
Synchronize a list
        Collections.synchronizedList()
        CopyOnWriteArrayList
 */

        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        list.add("practice");
        list.add("code");
        list.add("quiz");
/*
to do serial access it is critical that all access to the backing list is accomplished through
returned list. It is imperative that user manually synchronize on the returned list when iterating over it.
 */
        synchronized (list){
            //must be in a synchronized
            Iterator it = list.iterator();
            while(it.hasNext()){
                System.out.println(it.next()    );
            }
        }



        /*
        A thread safe variant of arraylist in which all mutative operations are implemented by creating a
        separate copy of underlying array. It achieves thread-safety by creating a separate copy list which is a different way than vector or other
        collections use to provide thread-safety.
        used when you don't want to synchronize the traversal, yet need to prevent interference among concurrent threads.
        it is costly as it involves separate Array copy with every write , very efficient if you have list and need to traverse over its elements and don't modify often

         */
        CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<>();
        threadSafeList.add("new1");
        threadSafeList.add("new2");
        threadSafeList.add("new3");
        threadSafeList.remove("new2");

        Iterator<String> it = threadSafeList.iterator();

        //it does not throw concurrentModificationException even if copyOnWriteArrayList is modified once iterator is created
        //because iterator is iterating over the separate copy of ArrayList while write operation is happening on another copy of ArrayList.
        while(it.hasNext()){
            System.out.println(it.next());
            //it.remove();// it throws UnsupportedOperationExample if you try to modify through iterators own method
        }

    }

    /*
    *
    * Iterable   -- it allows to obtain the iterator and traverse the sequence of elements , uses next()
    * Collection -- collection extends the iterable and represents an iterable group of elements which can be added removed or checked for presence in collection.
    * List       -- List is an ordered collection of elements. Think of it is an array of varied length.
    * ArrayList  -- Implementation of list
    * Synchronized
        * Collections.synchronizedList() method
        * CopyWriteArrayList -- thread safe and immutable

     */

}
