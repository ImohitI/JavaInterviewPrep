package geeksmustdoquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencyCount {

    public static void main(String[] args) {
       int n = 5;
       int A[] = {9,2,3,2,3,5,10,2,7};
       frequencycount_2(A,n);
       // [0, 2, 2, 0, 1, 0]
        //[1, 2, 2, 1, 0, 5]
    }
    public static void frequencycount(int arr[], int n)
    {
        // code here
        // code here
        int[] a = arr.clone();
        Arrays.fill(arr, 0);
        for(int i = 0 ; i <a.length ; i++){
            if(a[i]<=n)
                arr[a[i]-1] = arr[a[i]-1] +1;

        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(a));

    }
    public static void frequencycount_2(int arr[], int n)
    {
        //Decreasing all elements by 1 so that the elements
        //become in range from 0 to n-1.
        for (int j =0; j<n; j++)
            arr[j] = arr[j]-1;

        System.out.println(Arrays.toString(arr));
        //Using every element arr[i] as index.
        //Updating the array elements using mathematical formula
        //to find the frequencies of all elements from 1 to N.
        for (int i=0; i<n; i++)
            //Adding n to element present at arr[i]%n to keep
            //track of count of occurrences of arr[i].
            arr[arr[i]%n] = arr[arr[i]%n] + n;
        System.out.println(Arrays.toString(arr));
        //Calculating the frequency of each element.
        for (int i =0; i<n; i++)
            //Finally dividing the array elements by n to find the frequency.
            arr[i] = (arr[i]/n);

        System.out.println(Arrays.toString(arr));
    }
    public static void frequencycount_3(int arr[], int n)
    {
        for (int i =0; i<n; i++)
            arr[i] = arr[i]-1;
        for(int i=0;i<n;i++)
            arr[arr[i]%n]+=n;
        for(int i=0;i<n;i++)
            arr[i]/=n;

        System.out.println(Arrays.toString(arr));
    }
    public static void frequencycount_4(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
        for(int i=0;i<arr.length;i++) {
            arr[i] = ((map.containsKey(i+1)) ? map.get(i+1) : 0);
        }
        System.out.println(Arrays.toString(arr));
    }
}
/*

The first test case where your code failed:

Input:
37349
27162 38945 3271 34209 37960 17314 13663 17082 37769 2714 19280 17626 34997 33512 29275 25207 4706 12532 34909 23823 272 29688 19312 8154 5091 26858 30814 19105 14105 11303 16863 1861 2961 36601 10157 114 11491 31810 29152 2627 14327 30116 14828 37781 38925 16319 10972 4506 18669 19366 28984 6948 15170 24135 6256 38121 3835 38031 9855 25152 19132 23573 29587 1719 33440 26311 12647 23022 34206 39955 3791 18555 336 7317 12033 7278 27508 5521 24935 15078 915 35478 37253 6863 39182 23429 33867.................

Its Correct output is:
2 4 1 2 5 2 0 4 1 3 1 2 1 3 2 4 4 1 1 0 2 0 4 1 3 5 1 0 1 2 1 3 2 0 1 1 2 0 0 2 1 2 2 1 4 2 0 1 2 2 0 1 2 0 2 4 4 5 2 5 2 1 5 1 2 1 0 1 1 2 2 1 3 1 2 0 3 4 1 2 0 2 3 5 2 2 1 3 1 4 0 3 5 1 1 3 1 2 2 3 2 2 4 1 1 3 1 4 3 4 0 2 1 4 4 2 2 3 3 0 0 0 4 1 2 1 2 4 1 3 1 2 4 0 2 1 1 1 0 3 4 3 2 0 3 0 0 0 1 1 0 0 2 2 3 0 1 2 2 2 0 2 3 2 1 1 3 0 1 5 1 1 1 0 2 0 3 1 2 1 1 1 2 3 3 1 1 3 1 4 1 3 1 1 1 2 2 0 1 0 2 2 0 2 2 2 1 4 1 0 3 1 2 0 3 1 2 1 8 3 0 0 1 1 1 1 2 1 1 4 1 3 0 3 2 1 1 1 1 2 4 2 2 1 4 2 1 3 1 0 .................

And Your Code's output is:
1 0 0 0 1 0 0 1 0 2 1 2 0 0 1 1 2 1 1 0 0 0 2 1 2 2 0 0 1 0 1 2 2 0 1 1 1 0 0 1 0 1 0 0 1 0 0 0 1 1 0 1 1 0 1 2 3 3 2 2 2 1 3 1 1 1 0 1 0 1 0 0 1 1 2 0 1 3 1 0 0 2 1 4 0 1 0 1 0 3 0 1 2 0 0 1 1 1 1 3 1 0 2 1 0 3 1 3 2 2 0 2 0 2 3 1 0 0 1 0 0 0 3 0 0 0 1 3 1 2 0 1 2 0 2 0 0 0 0 2 2 2 1 0 0 0 0 0 1 0 0 0 2 2 2 0 0 0 1 2 0 0 2 1 1 1 2 0 1 3 0 1 0 0 1 0 1 1 1 0 0 0 1 1 0 1 0 2 0 2 1 3 1 0 1 2 0 0 1 0 1 1 0 1 2 1 0 3 0 0 1 0 1 0 2 0 2 1 4 2 0 0 1 0 0 1 2 0 0 1 0 2 0 2 2 1 0 0 0 0 2 0 1 0 2 1 0 2 0 0 .................
 */