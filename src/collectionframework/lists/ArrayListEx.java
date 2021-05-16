package collectionframework.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListEx {
    public static void main(String[] args) {
        /*
        ArrayList is backed by Object[]

        add(object)
        add(int index, object)  -- add value at index
        set(int index , object) -- change value at index

        remove(object)      -- if there are multiple such objects, then it removes first occurrence.
        remove(int index)   -- removes element from specific index.

        get(int index)
         */
        /*
        CopyOnWriteArrayList -- all modifications are implemented on a fresh copy
                                it is a thread safe version of ArrayList

         */

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");


        //String[] strarray = (String[])arrayList.toArray();// ClassCastException , because
        String[] strarray = arrayList.toArray(new String[0]);

        strarray[0] = "dfdfd";
        for(String s : arrayList){
            System.out.println(s);
        }
        if (1==1) {
            Object[] objectArray = new String[]{"first", "second", "third", "42"};
            String[] stringArray = (String[]) objectArray;
            for (String s : stringArray) {
                System.out.println(s);
            }
        }else {

            Object[] objectArray = new Object[4];
            objectArray[0]= "first";
            objectArray[1]= "second";
            objectArray[2]= "third";
            objectArray[3]= "42";
            String[] stringArray = (String[]) objectArray;//ClassCastException
            for (String s : stringArray) {
                System.out.println(s);
            }
        }

        /*
        Array copy
         */
        {
            int[] arr = {23, 45, 67};
            int[] copiedArr = new int[3];

            System.arraycopy(arr, 0, copiedArr, 0, 3);
            for (int x : copiedArr) {
                System.out.println(x);
            }
        }

        // clone
        {
            System.out.println("clone");
            int[] arr = {23, 45, 67};
            int[] copiedArr = arr.clone();

            arr [0] = -12;
            for (int x : copiedArr) {
                System.out.println(x);
            }

            Obj[] objarr = new Obj[2];
            objarr[0] = new Obj("A");
            objarr[1] = new Obj("B");

            Obj[] copiedObj = objarr.clone();
            objarr[0].name ="Z";// shallow copy , any change in the original or copied would cause the change in the other one even when the enclosed objects are cloneable


            for(Obj o : copiedObj){
                System.out.println(o);
            }
            ArrayList<Obj> list1 = new ArrayList<>();
            list1.add(new Obj("A"));
            list1.add(new Obj("B"));
            ArrayList<Obj> list2 = new ArrayList<>(list1); // shallow copy
           // list2.get(0).name = "FF";
            Obj o = list2.get(0);
            o.name = "FF";
            for(Obj x : list1){
                System.out.println(x);
            }


            List<String> listString = new ArrayList<>();
            listString.add("manoj");
            listString.add("sunil");

            Stream<String> stream = listString.stream();
            stream.forEach(element -> {System.out.println(element);});

        }


    }
}
class Obj{
    String name;
    Obj(String name){
        this.name = name;
    }
    public String toString(){
        return "["+name+"]";
    }
}