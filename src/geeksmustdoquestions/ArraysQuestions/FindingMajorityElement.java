package geeksmustdoquestions.ArraysQuestions;

import java.util.HashMap;
import java.util.Map;

public class FindingMajorityElement {
    public static void main(String[] args) {
        int a[] = {4,1,4,4,2} ;
       // int a[] = {1,13} ;
       int answer =  majorityElement_2(a);
        System.out.println(answer);
    }
    static int majorityElement(int a[])
    {
        // your code here
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int i=0 ; i < a.length ; i++){
            if(hmap.containsKey(a[i])){
                hmap.put(a[i], hmap.get(a[i])+1);
            }else{
                hmap.put(a[i] , 1);
            }
        }
        System.out.println(hmap.size());
        int maxFreq = -1;
        int maxElement = -1;

        for(Map.Entry<Integer,Integer> e : hmap.entrySet()){

            if( maxFreq < e.getValue()){
                maxElement = e.getKey();
                maxFreq = e.getValue();
            }
        }
        System.out.println("max element is "+maxElement+ " maxFreq "+maxFreq+" n/2 "+(a.length/2));
        return  maxFreq >(a.length/2) ?  maxElement : -1;
    }
    static int majorityElement_2(int a[])
    {
        // your code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0 ; i < a.length ; i++){
            if(map.containsKey(a[i])){
                map.put(a[i] , map.get(a[i])+1);

                if(map.get(a[i]) > a.length / 2){
                    return a[i];
                }
            }else{
                map.put(a[i], 1);
            }
        }

        return a.length == 1 ? a[0] : -1;
    }
}
