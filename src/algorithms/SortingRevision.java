package algorithms;

import java.util.Arrays;

public class SortingRevision {
    public static void main(String[] args) {
        int arr[] = {25 ,35 ,45 ,12 ,65 ,10};
        mergeSort(arr, 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left , int right){
        if(right <= left){
            return;
        }
        int mid = (left + right)/2;
        mergeSort(arr , left , mid);
        mergeSort(arr , mid+ 1, right);
        merge(arr , left , mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int lengthLeft = mid  - left + 1;
        int lengthRight = right - mid;

        int[] leftArr = new int[lengthLeft];
        int[] rightArr = new int[lengthRight];

        for(int i = 0 ; i <lengthLeft ; i++){
            leftArr[i] = arr[left+i];
        }
        for(int i = 0 ; i < lengthRight; i++){
            rightArr[i] = arr[mid+i+1];
        }

        int leftIndex = 0 , rightIndex = 0;

        for(int i = left ; i < right + 1; i++){
            if(leftIndex < lengthLeft && rightIndex < lengthRight){

                if(leftArr[leftIndex] < rightArr[rightIndex]){
                    arr[i] = leftArr[leftIndex++];
                }else{
                    arr[i] = rightArr[rightIndex++];
                }

            }else if(leftIndex < lengthLeft){
                arr[i] = leftArr[leftIndex++];

            }else if(rightIndex < lengthRight){
                arr[i] = rightArr[rightIndex++];

            }
        }
    }
}
