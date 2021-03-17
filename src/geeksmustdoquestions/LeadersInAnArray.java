package geeksmustdoquestions;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInAnArray {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here

        ArrayList<Integer> list = new ArrayList<Integer>();
        int peak = 0;
        for(int i=arr.length-1 ; i>=0; i--){
            if(i== arr.length-1){
                peak = arr[arr.length-1];
                list.add(peak);
                continue;
            }
            if(arr[i] >= peak){
                peak = arr[i];
                list.add(arr[i]);
            }

        }

        Collections.reverse(list);

        return list;
    }
}
