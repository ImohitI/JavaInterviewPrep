package geeksmustdoquestions.ArraysQuestions;

import java.util.Arrays;

public class RearrangeSortedArray {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70,80,90,100,110};
        rearrange_2(arr , 11);
        System.out.println(Arrays.toString(arr));


    }

    public static void rearrange(int arr[] , int size) {

        // Your code here

        int ascIndex = 0;
        int descIndex = arr.length - 1;
        int temp[] = arr.clone();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = temp[descIndex--];
            } else {
                arr[i] = temp[ascIndex++];
            }

        }

    }

    public static void rearrange_2(int arr[] , int size) {
        //Initialising index of first minimum and first maximum element.
        int n = arr.length;
        int max_idx = n - 1, min_idx = 0;

        //Storing maximum element of array.
        int max_elem = arr[n - 1] + 1;

        for (int i = 0; i < n; i++) {

            //At even index, we have to put maximum elements in decreasing order.
            if (i % 2 == 0) {
                System.out.println("arr[max_idx] "+arr[max_idx]+" max_elem "+max_elem+" arr[i] "+arr[i]+" >> "+(arr[max_idx] % max_elem));
                arr[i] += (arr[max_idx] % max_elem) * max_elem;
                //Updating maximum index.
                max_idx--;
            }

            //At odd index, we have to put minimum elements in increasing order.
            else {
                System.out.println("arr[min_idx] "+arr[min_idx]+" max_elem "+max_elem+" arr[i] "+arr[i]+" >> "+(arr[min_idx] % max_elem));

                arr[i] += (arr[min_idx] % max_elem) * max_elem;
                //Updating minimum index.
                min_idx++;
            }
        }

        System.out.println(Arrays.toString(arr));
        //Dividing array elements by maximum element to get the result.
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] / max_elem;

    }

    public static void rearrange_3(int arr[] , int n)
    {
        // initialize index of first minimum and first
        // maximum element
        //int n = arr.length;
        int max_ele = arr[n - 1];
        int min_ele = arr[0];
        // traverse array elements
        for (int i = 0; i < n; i++) {
            // at even index : we have to put maximum element
            if (i % 2 == 0) {
                arr[i] = max_ele;
                max_ele -= 1;
                }

            // at odd index : we have to put minimum element
            else {
                arr[i] = min_ele;
                min_ele += 1;
            }
        }
    }
    public static void rearrange_4(int arr[], int n){

        // Your code here
        int[] arr1 = new int[arr.length];
        int begin = 0;
        int end = n-1;
        int index = 0;
        while(begin < end){

            arr1[index++] = arr[end--];
            arr1[index++] = arr[begin++];
        }
       // System.out.println(Arrays.toString(arr1));
        if(n%2 == 1){

            arr1[n-1] = arr[n/2];
        }
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = arr1[i];
        }
    }

    public static void rearrange_5(int arr[], int n){

        // Your code here
        int[] arr1 = new int[arr.length];
        int begin = 0;
        int end = n-1;
        int index = 0;

        //1 , 2 , 3 , 4 , 5 , 6

        /*
        arr[i] += (arr[max_idx] % max_elem) * max_elem;
        1 + (6%7)*7 = new val
        1 + 42 = 43
           6*7/7 = 7

        arr[i] += (arr[min_idx] % max_elem) * max_elem;
        2 + (43%7 )* 7 = 9
         */

    }
}
