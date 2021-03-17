package geeksmustdoquestions;

import java.util.Arrays;

public class RearrangeSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        rearrange_3(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int arr[]) {

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

    public static void rearrange_2(int arr[]) {
        //Initialising index of first minimum and first maximum element.
        int n = arr.length;
        int max_idx = n - 1, min_idx = 0;

        //Storing maximum element of array.
        int max_elem = arr[n - 1] + 1;

        for (int i = 0; i < n; i++) {

            //At even index, we have to put maximum elements in decreasing order.
            if (i % 2 == 0) {
                System.out.println("arr[max_idx] "+arr[max_idx]+" max_elem "+max_elem+" arr[i] "+arr[i]);
                arr[i] += (arr[max_idx] % max_elem) * max_elem;
                //Updating maximum index.
                max_idx--;
            }

            //At odd index, we have to put minimum elements in increasing order.
            else {
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

    public static void rearrange_3(int arr[])
    {
        // initialize index of first minimum and first
        // maximum element
        int n = arr.length;
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
}
