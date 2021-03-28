package geeksmustdoquestions.ArraysQuestions;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInAnArray {
    public static void main(String[] args) {

        int [] arr = {13 , 87 , 45};
        leaders2(arr, 3);
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

        System.out.println(list);
        return list;
    }
    static ArrayList<Integer> leaders2(int arr[], int n){
        // Your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        int rMax = arr[n-1];
        list.add(arr[n-1]);
        for(int i = n-2 ; i >=0 ; i--){

            if(arr[i] >= rMax){
                list.add(arr[i]);
                rMax = arr[i];
            }

        }

        for(int i = 0 ; i < list.size()/2; i++){
            int temp = list.get(i);
            list.set(i , list.get(list.size() - i - 1));
            list.set(list.size() - i -1 , temp);
        }


        return list;
    }
}
