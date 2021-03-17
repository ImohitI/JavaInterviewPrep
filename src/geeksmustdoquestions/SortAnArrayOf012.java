package geeksmustdoquestions;

import java.util.Arrays;

public class SortAnArrayOf012 {
    public static void main(String[] args) {
        int arr[]= {0 ,2 ,1 ,2 ,0,1,0,2,1};
        sort012_2(arr);
        System.out.println(Arrays.toString(arr));
    }
    //two pointer method
    /*

    Time Complexity: O(n).
    Only one traversal of the array is needed.
    Space Complexity: O(1).
    No extra space is required.

     */
    public static void sort012(int a[]) {

        int lo = 0;
        int mid = 0;
        int high = a.length-1;
        int temp = 0;
        while (mid <= high) {
            switch (a[mid]) {
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[high];
                    a[high] = temp;
                    high--;
                    break;
                }
            }
        }
    }
/*
dividing problem into two parts
0 and 1
 1 and 2

 */
    public static void sort012_2(int a[]) {

        int lo = 0;
        int temp ;

        for(int i=0 ; i< a.length ; i++){
            if(a[i] ==2) continue;
            if(a[i] == 0){
                System.out.println("index i "+i);
                temp = a[lo];
                a[lo] = a[i];
                a[i] = temp;
                lo++;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(lo);
        for(int i=0 ; i< a.length ; i++){
            if(a[i] == 0) continue;
            if(a[i] == 1){
                System.out.println("index i ...."+i);
                temp = a[lo];
                a[lo] = a[i];
                a[i] = temp;
                lo++;
            }
        }
    }

}
