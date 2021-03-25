package geeksmustdoquestions.ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
       // List<Integer> list = subarraySum4(new int[]{ 15, 2, 4, 8, 9, 5, 10, 23 }, 23);
        //List<Integer> list = subarraySum4(new int[]{ 24,24,24,24 ,2, 4, 8, 9}, 23);
        List<Integer> list = subarraySum4(new int[]{113,68,100,36,95,104,12,123,134} , 468);

        System.out.println(list.toString());
    }
    //On2 , they may not give the lowest index sub array
    static ArrayList<Integer> subarraySum(int[] arr, int s) {

        // Your code here
        // unsorted array
        // 1,2,3,7,5    12
        // 1,3,6,13,18
        // n2 loop to get the difference as 12 then store the indexes ,

        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i= 1;i < arr.length ; i++){
            sum[i] = sum[i-1] + arr[i];
        }

        for(int i=0 ; i < arr.length ; i++){
            for(int j = 0; j < arr.length ; j++){
                if(Math.abs(sum[i]-sum[j]) == s){
                    list.add(i+2);
                    list.add(j+1);
                    return list;
                }
            }
        }
        return list;

    }
//On2 ....O1
    static ArrayList<Integer> subarraySum2(int[] arr, int s) {

        // Your code here
        // unsorted array
        // 1,2,3,7,5    12
        // 1,3,6,13,18
        // n2 loop to get the difference as 12 then store the indexes ,

        int currentSum = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0 ; i < arr.length ; i++){
            currentSum = arr[i];
            //all sub arrays starting with i
            for(int j = i+1; j <= arr.length ; j++){
               if(currentSum == s){
                   list.add(i);
                   list.add(j);
                   return  list;
               }
               if(currentSum > s || j == arr.length){
                   break;
               }
                currentSum += arr[j];
            }
        }
        return list;
    }
    static ArrayList<Integer> subarraySum3(int[] arr, int s) {

        // Your code here
        // unsorted array
        // 1,2,3,7,5    12
        // check the sum of all the sub array

        int currentSum = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0 ; i < arr.length ; i++){
            currentSum = arr[i];
            //all sub arrays starting with i
            for(int j = i+1; j <= arr.length ; j++){
                if(currentSum == s){
                    list.add(i+1);
                    list.add(j+1);
                    return  list;
                }
                if(currentSum > s || j == arr.length){
                    break;
                }
                currentSum += arr[j];
            }
        }
        return list;
    }
    static ArrayList<Integer> subarraySum4(int[] arr, int s) {

        // Your code here
        // unsorted array
        // 1,2,3,7,5    12
        // using two pointer  , when currsum < sum , increase end and add the new element , when curr sum > sum decrease the element and increase start
        //

        int currentSum = arr[0];
        int start = 0;
        int end = 1;

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> nolist = new ArrayList<>();
        nolist.add(-1);
        while(start <= end && end <= arr.length){
            System.out.println("start  "+start+" end "+end+" currentSum "+currentSum);
            if(currentSum == s){

                list.add(start+1);
                list.add(end);
                return list;
            }

            if(currentSum > s){
                System.out.println("going to subtract "+arr[start]);
                currentSum -= arr[start++];
            }else if(currentSum < s ){
                if(end >= arr.length){
                    break;
                }
                System.out.println("going to add "+arr[end]);
                currentSum += arr[end++];
            }

        }
        return nolist;
    }

    //geeks for geeks official solution
    static ArrayList<Integer> subarraySum5(int[] arr, int n, int s) {
        int first = 0;
        int last = 0;

        long result = arr[first];

        ArrayList<Integer> res = new ArrayList<Integer>();
        while (result != s) {
            if (result > s) {
                if (first == last) {
                    last++;
                    first++;
                    if (last >= n) break;
                    result = arr[first];
                } else {
                    result -= arr[first];
                    first++;
                }
            } else {
                last++;
                if (last < n) {
                    result += arr[last];
                } else {
                    break;
                }
            }
        }

        if (result != s) {
            res.add(-1);
        } else {
            res.add(first + 1);
            res.add(last + 1);

        }
        return res;
    }

}
