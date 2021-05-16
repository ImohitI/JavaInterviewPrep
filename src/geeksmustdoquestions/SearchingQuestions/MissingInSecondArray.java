package geeksmustdoquestions.SearchingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingInSecondArray {
    public static void main(String[] args) {
        long[] A = {1 , 2 , 3 , 4 , 5 , 10};
        long[] B = {2 , 3 , 1 , 0 , 5};
    }
    static ArrayList<Long> findMissing(long A[], long B[], int N, int M)
    {
        Arrays.sort(B);
        ArrayList<Long> result = new ArrayList<>();
        for(long l : A){
            if(!binarySearch(B, l)){
                result.add(l);
            }
        }
        return result;
    }

    static boolean binarySearch(long arr[] , long x){

        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] == x){
                return true;
            }else if(arr[mid] < x){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return false;
    }

    //hashMethod
    static ArrayList<Long> findMissing2(long A[], long B[], int N, int M)
    {
        ArrayList<Long> result = new ArrayList<>();
        Set<Long> set = new HashSet<>();

        for(long x : B){
            set.add(x);
        }

        for(long x : A){
            if(!set.contains(x)){
                result.add(x);
            }
        }

        return  result;
    }
}
