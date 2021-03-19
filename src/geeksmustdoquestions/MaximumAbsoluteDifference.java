package geeksmustdoquestions;

public class MaximumAbsoluteDifference {


    /*
    Case 1: A[i] > A[j] and i > j
    |A[i] - A[j]| = A[i] - A[j]
    |i -j| = i - j
    hence, f(i, j) = (A[i] + i) - (A[j] + j)

    Case 2: A[i] < A[j] and i < j
    |A[i] - A[j]| = -(A[i]) + A[j]
    |i -j| = -(i) + j
    hence, f(i, j) = -(A[i] + i) + (A[j] + j)

    Case 3: A[i] > A[j] and i < j
    |A[i] - A[j]| = A[i] - A[j]
    |i -j| = -(i) + j
    hence, f(i, j) = (A[i] - i) - (A[j] - j)

    Case 4: A[i] < A[j] and i > j
    |A[i] - A[j]| = -(A[i]) + A[j]
    |i -j| = i - j
    hence, f(i, j) = -(A[i] - i) + (A[j] - j)
     */
    public static void main(String[] args) {
        int[] array = { -70, -64, -6, -56, 64,
                61, -57, 16, 48, -98 };
        maxValue_2(array);
    }

    static int maxValue(int[] arr, int N) {
        // code here

        int max = 0;

        for(int i=0 ; i < arr.length ; i++){
            for(int j =0 ; j <arr.length ; j++){
                int diff = Math.abs(arr[i] - arr[j]) + Math.abs(i-j);
                max = Math.max(max, diff);
            }
        }

        return max;
    }
    static int maxValue_2(int[] arr) {

        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++)
        {

            max1 = Math.max(max1, arr[i] + i);
            min1 = Math.min(min1, arr[i] + i);
            max2 = Math.max(max2, arr[i] - i);
            min2 = Math.min(min2, arr[i] - i);
        }
        return Math.max(max1 - min1, max2 - min2);

    }
    public int maxValue_3(int arr[], int N) {
        int []a = new int [N];
        int []b = new int [N];


        // Calculating first_array and second_array
        for (int i = 0; i < N; i++) {
            a[i] = (arr[i] + i);
            b[i] = (arr[i] - i);
        }

        int x = a[0], y = a[0];

        // Finding maximum and minimum value in
        // first_array
        for (int i = 0; i < N; i++) {
            if (a[i] > x)
                x = a[i];

            if (a[i] < y)
                y = a[i];
        }

        // Storing the difference between maximum and
        // minimum value in first_array
        int ans1 = (x - y);

        x = b[0];
        y = b[0];

        // Finding maximum and minimum value in
        // second_array
        for (int i = 0; i < N; i++) {
            if (b[i] > x)
                x = b[i];

            if (b[i] < y)
                y = b[i];
        }

        // Storing the difference between maximum and
        // minimum value in second_array
        int ans2 = (x - y);

        return Math.max(ans1, ans2);
    }
}
