package geeksmustdoquestions.ArraysQuestions;

import java.util.Arrays;
import java.util.List;

public class MaxMinElementSubArray {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,5,4,6,8);
        maxMin(list, 3);
    }


    public static int maxMin(List<Integer> arr, int k) {
        // Write your code here
        int start = 0 ;
        int end = 0;
        int localMin = Integer.MAX_VALUE;
        int maxMin = Integer.MIN_VALUE;

        while(end < arr.size()){
            System.out.println(" >> "+arr.get(end)+"  start "+start+" end "+end + " localMin "+localMin);

            localMin = Math.min(arr.get(end), localMin);
            if(end - start + 1 == k){
                maxMin = Math.max(localMin, maxMin);
                start++;

            }
            end++;
        }
        System.out.println(maxMin );
        return maxMin;
    }
}
