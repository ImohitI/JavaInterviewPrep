package oldmainfiles;

import java.io.*;
import java.util.*;

public class Main003 {

    public static void main(String[] args) {
        /*
        *
        * Map implementation
        * HashMap
        * HashTable
        * EnumMap
        * IdentityHashMap
        * LinkedHashMap
        * Properties
        * TreeMap
        * WeakHashMap
        *
        * HashMap is a Hashtable based implementation of Map interface.
        * HashMap class is roughly equivalent to Hashtable, except that is un-synchronized and permits nulls
        * No guarantee of order of the map.
        * Implementation provides constant time performance of basic operations like get and put.
        * The instance has initial capacity and initial load factor.
        * The capacity is the number of buckets in the hash table, and the initial capacity is simply the capacity
        * at the time the hash table is created.
        * Load factor is a measure of how full the hash table is allowed to get before its capacity
        * is automatically increased.
        * Inner implementation
        * Hashmap contains an array of Node and Node can represent a class having following objects.
        * int hash
        * K key
        * V value
        * Node next
        *
        * Hashing is a process of converting an object into integer form using the method hashCode()
        * hashCode() method of object class returns the memory reference of object in integer form.
        *
        * Buckets -- is one element of HashMap array. It is used to store nodes. Two or more nodes
        * can have the same bucket. In that case link list structure is used to connect the nodes.
        * Buckets are different in capacity
         */
        Map<Integer, String> hmap = new HashMap<>();

        hmap.put(1, "One");
        //hmap.put(new Integer(1),"newOne");

        //print
        for(Integer i : hmap.keySet()){
            //System.out.println(hmap.get(i));
        }
        //lambda
        hmap.entrySet().forEach(entry  -> System.out.println(entry.getKey()+" "+entry.getValue()));

        //using entrySet for printing
        for(Map.Entry<Integer, String> entry : hmap.entrySet()){
            //System.out.println(entry.getKey() + " "+entry.getValue());
        }

        Map<Integer, String> hmap2 = new HashMap<>();
        hmap2.put(2,"two");
        hmap.putAll(hmap2);

        String valu = hmap.getOrDefault(3,"X");
        //System.out.println(valu);

        boolean hasValue = hmap.containsValue("One");
        boolean hasKey = hmap.containsKey(1);

        Iterator iterator = hmap.keySet().iterator();

        while(iterator.hasNext()){
            Object key = iterator.next();
            Object val = hmap.get(key);
        }

        hmap.replace(1, "newOne");
        hmap.replace(4,"oooo");

        //functional operation in hashmap
        hmap.compute(1 ,(key, value) -> value == null ? null : value.toString().toUpperCase());

        hmap.computeIfAbsent(3, (key)-> "three");

        hmap.computeIfPresent(2, (key, value) ->value == null ? null : value.toString().toUpperCase());


        hmap.merge(3 , "XYZ", (oldValue, newValue)-> oldValue+newValue +"-abc");

        for(Integer i : hmap.keySet()){
            System.out.println(hmap.get(i));
        }

        //Properties
        /*
        *
        * Java Properties is like Java Map of Java String key and value pairs. It can write the key , value pair to a properties file on disk.
        *
         */
        Properties properties = new Properties();
        properties.setProperty("name","Mohit Kumar");
        String name = properties.getProperty("name");
        System.out.println(name);

        //store
        try(FileWriter output = new FileWriter("src/resources/props.properties")){
            properties.store(output, "These are properties");

        }catch (IOException e){
            e.printStackTrace();
        }

        Properties p = new Properties();
        try(FileReader fileReader = new FileReader("src/resources/props.properties")){
            p.load(fileReader);
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(p.getProperty("name"));

        try(FileOutputStream outputStream = new FileOutputStream("src/resources/props.xml")){
            p.storeToXML(outputStream , "These are properties");
        }catch (IOException e){
            e.printStackTrace();
        }

        Properties p1 = new Properties();
        try(FileInputStream inputStream = new FileInputStream("src/resources/props.xml")){
            p1.loadFromXML(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(p1.getProperty("name"));



        /*
        *
        * Queue is a collection designed to hold elements prior to processing, the elements waiting
        * in line to be consumed
        * Implementation
        * LinkedList
        * ArrayDeque -- implementation backed by resizable array
        * PriorityQueue -- queue of sorted elements
        * PriorityQueue won't change its order if you mutate the elements inside it.
         */

        Queue<String> queue = new LinkedList<>();
        queue.add("elements1");
        queue.add("elements2");

        //poll and remove both removes first element
        //poll returns null if queue is empty.
        //remove throws an exception if queue is empty

    }
}
