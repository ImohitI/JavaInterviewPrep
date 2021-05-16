package geeksmustdoquestions.SearchingQuestions;

import java.util.Arrays;

public class Median2SortedArray {
    public static void main(String[] args) {
        int n = 2 ;
        int[] a = {1,2};
        int m = 2;
        int[] b = {3,4};

        medianOfArray(n,m, a, b);

    }
    static double medianOfArray(int n , int m , int a[] , int b[]){
        int[] arr = new int[n+m];
        int i = 0;
        int j = 0;
        int index = 0;
        double median = 0d;
        while(i<n && j <m ){
            if(a[i]<b[j]){
                arr[index++] = a[i++];
            }else{
                arr[index++] = b[j++];
            }
        }

        while(i<n){
            arr[index++] = a[i++];
        }

        while(j<m){
            arr[index++] = b[j++];
        }
        System.out.println(Arrays.toString(arr));
        if((n+m)%2 == 0){
            System.out.println(" "+(((n+m)/2)-1)+" "+((n+m)/2));
            median = (double)( arr[((n+m)/2)-1] + arr[((n+m)/2)] ) / 2;
        }else{
            median = arr[(n+m)/2];
        }

        System.out.println(median);
        return median;
    }
}
