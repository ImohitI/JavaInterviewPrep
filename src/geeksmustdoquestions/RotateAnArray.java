package geeksmustdoquestions;

import java.util.Arrays;

public class RotateAnArray {
    public static void main(String[] args) {
    int arr[] = {1,2,3,4,5};
    rotateArr(arr, 2);
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
}
