package geeksmustdoquestions.ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class AlternatePosNegNumbers {
    public static void main(String[] args) {
        int[] arr = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        rearrange(arr,9);
        System.out.println(Arrays.toString(arr));
        //[5, -1, 0, -3, 9, -5, 4, -2, 2]
    }
    static void rearrange(int arr[], int n) {

        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (arr[i] < 0)
                neg.add(arr[i]);
            else
                pos.add(arr[i]);
        }

        int i = 0, j = 0, k = 0;
        while (i < neg.size() && j < pos.size()) {
            arr[k++] = pos.get(j++);
            arr[k++] = neg.get(i++);
        }   
        while (j < pos.size()) { arr[k++] = pos.get(j++); }

        while (i < neg.size()) { arr[k++] = neg.get(i++); }
    }
    static void rearrange_2(int arr[], int n)
    {
        // The following few lines are similar to partition
        // process of QuickSort.  The idea is to consider 0
        // as pivot and divide the array around it.
        int i = -1, temp = 0;
        for (int j = 0; j < n; j++)
        {
            if (arr[j] < 0)
            {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Now all positive numbers are at end and negative numbers at
        // the beginning of array. Initialize indexes for starting point
        // of positive and negative numbers to be swapped
        int pos = i+1, neg = 0;

        // Increment the negative index by 2 and positive index by 1, i.e.,
        // swap every alternate negative number with next positive number
        while (pos < n && neg < pos && arr[neg] < 0)
        {
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
    }

}
