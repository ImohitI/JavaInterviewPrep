package geeksmustdoquestions.ArraysQuestions;

import java.util.Arrays;

public class SmallestPositiveIntegerNoSum {

    public static void main(String[] args)
    {
        SmallestPositiveIntegerNoSum small = new SmallestPositiveIntegerNoSum();
        int arr1[] = {1, 2, 3, 7};
        int n1 = arr1.length;
        System.out.println(small.findSmallest(arr1, n1));

        int arr2[] = {1, 2, 6, 10, 11, 15};
        int n2 = arr2.length;
        System.out.println(small.findSmallest(arr2, n2));

        int arr3[] = {1, 1, 1, 1};
        int n3 = arr3.length;
        System.out.println(small.findSmallest(arr3, n3));

        int arr4[] = {1, 1, 3, 4};
        int n4 = arr4.length;
        System.out.println(small.findSmallest(arr4, n4));

    }
//-- optimal solution
    private int findSmallest(int[] arr, int n) {
        Arrays.sort(arr);
        int res = 1;
        for(int i = 0 ; i < n && arr[i] <= res; i++){
            res = res + arr[i];
        }

        return res;
    }
    //other solution
    /*
    core logic
     1 , 2 , 3     new element is x
     6
     if x is <= 6 + 1 then range extends by 6
     x = 4
     1 , 2 , 3, 4 , 5 , 6, 7 , 8 , 9 , 10

     if x = 8
     1 , 2 , 3 , 4, 5 , 6, 9 , 10 , 11 , 12, 13  ..
     here there will be a gap
     */
    /*
    a , b , c     e , f , g
    1 to 6
    e = 6
    1 to 12
    e = 8
    cannot create an 7
    stop when next element is > previous max + 1

https://medium.com/dexters-lab/eli5-find-the-smallest-positive-integer-value-that-cannot-be-represented-as-sum-of-any-subset-of-f8ea2488184b
     */

    private int findSmallest2(int[] arr, int n) {
        Arrays.sort(arr);
        int maxPossible = 0;

        if(arr.length == 0 || arr[0] !=1){
            return maxPossible + 1;
        }
        //after verification that ! exist in the array

        for(int i=1 ; i < arr.length ; i++){
            // if the current element is > than maxPossible + 1
            // that leaves a gap
            if(arr[i] > maxPossible + 1){
                break;
            }
            maxPossible += arr[i];
        }
        return maxPossible + 1;
    }
}
