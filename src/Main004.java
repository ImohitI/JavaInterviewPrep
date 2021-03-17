import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import tests.FirstUnitTest;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertTrue;

public class Main004 {
    public static void main(String[] args) {
        /*
        *
        * ConcurrentHashMap
        * is  an enhancement of HashMap , thread safe
        * at any time any number of threads are applicable for a read operation
        * without locking concurrent hashmap object which is not there in HashMap.
        * In concurrent hashmap objects are divided into a number of segments according
        * to concurrency level
        * the default concurrency level is 16
        * At any time any number of threads can perform retrieval operation but for updating
        * in the object, the thread must lock the particular segment in which thread wants to operate
        * This type of locking is known as bucket locking or segment locking.
        * Inserting null objects is not possible in concurrentHashMap as key or value.
        *
         */


        ConcurrentHashMap<Integer, String> cmap = new ConcurrentHashMap<>();

        cmap.put(100, "Hello");
        cmap.put(101, "World");


//ConcurrentHashMap
        Map<String,String> myMap = new ConcurrentHashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("ConcurrentHashMap before iterator: "+myMap);
        Iterator<String> it = myMap.keySet().iterator();

        while(it.hasNext()){
            String key = it.next();
            if(key.equals("3")) myMap.put(key+"new", "new3");
        }
        System.out.println("ConcurrentHashMap after iterator: "+myMap);

        //HashMap
        myMap = new HashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("HashMap before iterator: "+myMap);
        Iterator<String> it1 = myMap.keySet().iterator();
//
//        while(it1.hasNext()){
//            String key = it1.next();
//            if(key.equals("3")) myMap.put(key+"new", "new3");
//        }
        System.out.println("HashMap after iterator: "+myMap);

        /*
        *If the key value is only modified then no concurrent Modification exception is thrown
        *
         */
         Map<String, String> mySyncMap = Collections.synchronizedMap(myMap);
         /*
         *
         * synchronizedMap and Hashtable are thread safe , but it is not efficient.
         * ConcurrentHashMap consists of array of nodes as a table bucket
         * table buckets are initialized lazily, upon the first insertion. Each bucket can be independently locked
         * by locking the very first node in the bucket.Read operations do not block and update contentions are minimized.
         *
         * ConcurrentMap guarantees memory consistency on key/value operations in a multi-threading environment.
         * Actions in a thread prior to placing an object into a concurrentMap as a key or value happens-before actions
         * subsequent to the access or removal of that objects in another thread.
          */

        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        junit.run(FirstUnitTest.class);
    }

}
