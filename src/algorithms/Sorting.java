package algorithms;

public class Sorting {
    //bubble sort o(n2)
    public static void bubbleSort(int[] arr){
        boolean sorted = false;
        int temp;
        while(!sorted){
            sorted = true;
            for(int i = 0; i < arr.length ; i++){
                if(arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    //insertion sort O(n^2)
    public static void insertionSort(int[] arr){
        for(int i = 1 ; i < arr.length ; i++){
            int current = arr[i];
            int j = i - 1;
            while(j >=0 && current < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }


    //selection sort O(n^2)
    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length ; i++){
            int minId = i;//assume current element is min ,compare with all the element with greater index
            for(int j = i + 1; j < arr.length ; j++){
                if(arr[minId] < arr[j]){
                    minId = j;
                }
            }
            //swapping
            int temp = arr[i];
            arr[i] = arr[minId];
            arr[minId] = temp;
        }
    }

    //MergeSort O(nlogn) in all cases
    public static void mergeSort(int[] arr, int left, int right){
        if(right <= left) return;
        int mid = (left + right)/2;
        mergeSort(arr, left , mid);
        mergeSort(arr, mid+1 , right);
        merge(arr, left, mid, right);
    }
    static void merge(int[] arr, int left, int mid, int right){
        //calculating length
        int lengthLeft = mid - left +1;
        int lengthRight = right - mid;

        //creating temporary subarrays
        int leftArray[] = new int[lengthLeft];
        int rightArray[] = new int[lengthRight];

        //copying our sorted subarrays into temp
        for(int i = 0; i < lengthLeft ; i++){
            leftArray[i] = arr[left + i];
        }
        for(int i = 0; i < lengthRight ; i++){
            rightArray[i] = arr[mid + i + 1];
        }

        //iterator containing current index of temp subarrays
        int lefIndex = 0;
        int rightIndex = 0;

        //copying from left and right subArray back to array
        for(int i = left; i < right + 1; i++ ){
            if(lefIndex < lengthLeft && rightIndex < lengthRight){
                if(leftArray[lefIndex] < rightArray[rightIndex]){
                    arr[i] = leftArray[lefIndex];
                    lefIndex++;
                }else{
                    arr[i] = rightArray[rightIndex];
                    rightIndex++;
                }

                //if all the elements have been copied from rightArray, copy the rest of leftArray
            }else if(lefIndex < lengthLeft){
                arr[i] = leftArray[lefIndex];
                lefIndex++;

                //if all elements have been copied from leftArray, copy rest from rightArray
            }else if(rightIndex < lengthRight){
                arr[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }

    }

    //Heap Sort O(nlogn) all casese , space is O(1)
    public static void heapSort(int[] arr){
        if(arr.length == 0) return;

        //building heap
        int length = arr.length;

        //we are going from first non leave to the root
        for(int i = length / 2-1; i >=0 ;i++){
            heapify(arr, length, i);
        }

        for(int i = length -1; i >= 0; i--){
            int temp = arr[0];
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr , i , 0);
        }

    }

    private static void heapify(int[] arr, int length, int i) {
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;
        int largest = i;

        //if left child is larger than parent
        if(leftChild < length && arr[leftChild] > arr[largest]){
            largest = leftChild;
        }

        //if right child is larger than parent
        if(rightChild < length && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }

        //if a swap needs to occur
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, length, largest);
        }
    }

    //QuickSort worst case On^2 , best case O(nlogn), average O(nlogn)
    public static void quickSort(int[] arr , int begin , int end){
        if(end <= begin) return;

        int pivot = partition(arr, begin , end);
        quickSort(arr, begin , pivot - 1);
        quickSort(arr , pivot +1 , end);
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for(int i = begin ; i < end ; i++){
            if(arr[i] < arr[pivot]){
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = temp;

        return counter;
    }

}
