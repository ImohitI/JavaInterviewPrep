package geeksmustdoquestions.SortingQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountInversions {
    static int COUNT = 0;
    public static void main(String[] args) {
//        long[] arr = {2, 4, 1, 3, 5};
//        inversionCount2(arr, 5);
//        System.out.println(COUNT);
//        System.out.println(Arrays.toString(arr));
        long[] arr = {468,335,1,170,225,479,359,463,465,206,146,282,328,462,492,496,443,328,437,392,105,403,154,293,383,422,217,219
                ,396,448,227,272,39,370,413,168,300,36,395,204,312,323};
        System.out.println(arr.length);
        System.out.println(inversionCount2(arr,42));
//        System.out.println(COUNT);
//        System.out.println(Arrays.toString(arr));

      /*  Its Correct output is:
        494

        And Your Code's output is:
        474
*/
    }
    //On2  brute force
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here

        //HashMap<String, Integer> map = new HashMap<>(); due to repetition map will not be helpful
        int count = 0;
        for(int i = 0 ; i < N-1 ; i++){
            for(int j = i ; j < N ; j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
/*
        for(Map.Entry<String , Integer> e : map.entrySet()){
            System.out.println(e.getKey()+" >>> "+e.getValue());
        }*/

        //System.out.println(count);

        return count;
    }
 //not working
    static void inversionCount222(long arr[], long N)
    {
        // Your Code He
       partition(arr, 0 , arr.length-1 );

    }
    static void partition (long[] arr , int start , int end){


        if(start < end) {
            int mid = (end + start) / 2;
            // System.out.println(start+" "+end);
             partition(arr, start, mid);
             partition(arr, mid + 1, end);
             merger(arr, start, mid, end);
        }

    }

    private static void merger(long[] arr, int start, int mid, int end) {
       // System.out.println("merge "+start+" "+mid +" "+ end);
       // int count = 0;
        long[] l = new long[mid - start + 1];
        long[] r = new long[end - mid];

        int index = 0;
        for(int i = start ; i <= mid ; i++){
            l[index++] = arr[i];
        }
        index = 0;
        for(int i = mid+1 ; i <= end ; i++ ){
            r[index++] = arr[i];
        }
        int j1 = 0 , j2 = 0;

        while(j1 < l.length && j2 < r.length){
            if(l[j1] > r[j2]){
                j2++;
              //  System.out.println("inc count "+l[j1]+" "+r[j2-1]);
                COUNT = COUNT + (l.length -j1);
            }else if(l[j1] <= r[j2]){
                j1++;
            }
        }
        j1 = 0 ;
        j2 = 0;

        while(j1 < l.length && j2 < r.length){
            if(l[j1] < r[j2]){
                arr[start++] = l[j1];
                j1++;
            }else{
                arr[start++] = r[j2];
                j2++;
            }
        }

        while(j1 < l.length){
            arr[start++] = l[j1++];
        }

        while(j2 < r.length){
            arr[start++] = r[j2++];
        }

       // return count;
    }




    // solution 2

    static long inversionCount2(long arr[], long N)
    {
        //long temp[] = new long[(int) N];
        return mergeSort2(arr  , 0 , (int)N-1);
    }

    private static long mergeSort2(long[] arr, long left, long right) {
        long mid , invCount = 0;
        if(right > left){
            mid = (left + right)/2;

            invCount = mergeSort2(arr  , left, mid);
            invCount += mergeSort2(arr , mid + 1, right);
            invCount += merge2(arr , left, mid , right);
        }
        return invCount;
    }

    private static long merge2(long[] arr, long left, long mid, long right) {
        long i , j , k;
        long invCount = 0;
        i = 0;
        j = 0;
        k = left;
        long lengthLeft = mid  - left + 1;
        long lengthRight = right - mid;

        long[] leftArr = new long[(int)lengthLeft];
        long[] rightArr = new long[(int)lengthRight];

        for(int h = 0 ; h <lengthLeft ; h++){
            leftArr[h] = arr[(int)left+h];
        }
        for(int h = 0 ; h < lengthRight; h++){
            rightArr[h] = arr[(int)mid+h+1];
        }

        while((i < leftArr.length) && (j < rightArr.length)){
            if(leftArr[(int)i] <= rightArr[(int)j]){
                arr[(int)k++] = leftArr[(int)i++];
            }else{
                arr[(int)k++] = rightArr[(int)j++];
                invCount += (leftArr.length -i);
            }
        }

        while(i < leftArr.length ){
            arr[(int)k++] = leftArr[(int)i++];
        }

        while(j < rightArr.length){
            arr[(int)k++] = rightArr[(int)j++];
        }

        // for(i = left ; i <= right ; i++){
        //     arr[(int)i] = temp[(int)i];
        // }

        return invCount;
    }

    // solution 3

    static long inversionCount3(long arr[], long N)
    {
        long temp[] = new long[(int) N];
        long count =  mergeSort3(arr , temp , 0 , (int)N-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(temp));
        return count;
    }

    private static long mergeSort3(long[] arr, long[] temp, long left, long right) {
        long mid , invCount = 0;
        if(right > left){
            mid = (left + right)/2;

            invCount = mergeSort3(arr , temp , left, mid);
            invCount += mergeSort3(arr , temp, mid + 1, right);
            invCount += merge3(arr , temp , left, mid + 1 , right);
        }
        return invCount;
    }

    private static long merge3(long[] arr, long[] temp, long left, long mid, long right) {
        long i , j , k;
        long invCount = 0;
        i = left;
        j = mid;
        k = left;

        while((i <= mid -1) && (j <= right)){
            if(arr[(int)i] <= arr[(int)j]){
                temp[(int)k++] = arr[(int)i++];
            }else{
                temp[(int)k++] = arr[(int)j++];
                invCount += (mid-i);
            }
        }

        while(i <= mid - 1){
            temp[(int)k++] = arr[(int)i++];
        }

        while(j <= right){
            temp[(int)k++] = arr[(int)j++];
        }

        for(i = left ; i <= right ; i++){
            arr[(int)i] = temp[(int)i];
        }

        return invCount;
    }

}
