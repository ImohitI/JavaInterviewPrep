package geeksmustdoquestions.ArraysQuestions;

import java.util.Arrays;

public class RotateAnArray {
    public static void main(String[] args) {
    int arr[] = {1,2,3,4,5,6,7,8,9};
        // 7 6 5 4 3 2 1
        // 5 6 7 4 3 2 1
        // 5 6 7 1 2 3 4

    rotateArr_6(arr, 3,9);
        System.out.println(Arrays.toString(arr));
    }
    static void rotateArr(int arr[], int d) {

        int[] temp = arr.clone();

       for(int i = 0; i < temp.length ; i++){
           int newIndex = i - d ;
           if(newIndex < 0){
               newIndex =  (arr.length-1) + (newIndex +1);
           }
           System.out.println("newIndex "+newIndex+" i "+i);
           arr[newIndex] = temp[i];
       }

    }
    static void rvereseArray(int arr[], int start, int end)
    {
        int temp;

        while (start < end) {
            //Swapping values at start index and end index.
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            //Updating the values of start and end.
            start++;
            end--;
        }
    }
    //Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d, int n)
    {
        //First reversing d elements from starting index.
        rvereseArray(arr, 0, d-1);
        //Then reversing the last n-d elements.
        rvereseArray(arr, d, n - 1);
        //Finally, reversing the whole array.
        rvereseArray(arr, 0, n - 1);
    }

    //Ond
    void leftRotate(int arr[], int d, int n)
    {
        for (int i = 0; i < d; i++)
            leftRotatebyOne(arr, n);
    }

    void leftRotatebyOne(int arr[], int n)
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[n-1] = temp;
    }

    //On O1
    void leftRotate_2(int arr[], int d, int n)
    {
        /* To handle if d >= n */
        d = d % n;
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    /*Function to get gcd of a and b*/
    int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    static void rotateArr_5(int arr[], int d, int n)
    {
        // add your code here

        int[] temp = new int[d];
        for(int i=0 ; i< d; i++){
            temp[i] = arr[i];
        }

        int index = 0;
        for(int i = 0 ; i<arr.length; i++){
            if(i < arr.length - d){
                arr[i] = arr[i+d];
            }else{
                //System.out.println(" i "+i+" d "+d);
                arr[i] = temp[index++];
            }

        }

    }
    static void rotateArr_6(int arr[], int d, int n)
    {
        // add your code here
        d = d % n;

        reverse(arr , 0 , n-1);
        reverse(arr, 0 , n-d-1);
        reverse(arr, n-d , n-1);



    }

    public static void reverse(int[] nums , int start , int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}
