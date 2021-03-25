package geeksmustdoquestions.ArraysQuestions;

import java.util.Arrays;

public class MergeWithoutExtraSpace {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};
        int n = 4;
        int m = 5;
        //merge(arr1, arr2 , n , m);
        merge_2(arr1, arr2 , n , m);
        System.out.println(Arrays.toString(arr1)+" "+Arrays.toString(arr2));
    }

    //geeks for geeks solution
    public static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    public static void merge(int arr1[], int arr2[], int n, int m) {
        int i, j, gap = n + m, tmp;

        System.out.println(" gap "+gap);

        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            System.out.println("....gap..."+gap);
            for (i = 0; i + gap < n; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    tmp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = tmp;
                }
            }

            for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    tmp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = tmp;
                }
            }

            if (j < m) {
                for (j = 0; j + gap < m; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        tmp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = tmp;
                    }
                }
            }
        }
    }

    public static void merge_2(int arr1[], int arr2[], int n, int m) {

        //int j = 0;

        for(int i = 0; i < arr1.length ; i++){

            if(arr1[i] > arr2[0]){
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }
            int first = arr2[0];
            int k = 1 ;
            while( k < m && first > arr2[k]){

                    arr2[k-1] = arr2[k];
                    k++;
            }
            System.out.println("---"+k);
            arr2[k-1] = first;

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
        }


    }
}
