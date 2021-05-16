package geeksmustdoquestions.SearchingQuestions;

public class BitonicPoint {
    public static void main(String[] args) {

    }
    public static int findMaximum(int arr[] , int n){
        return findMaximum(arr, 0 , n-1);
    }

    private static int findMaximum(int[] arr, int low, int high) {
        //base case only one element is present in the array
        if(low == high){
            return arr[low];
        }

        if((high == low + 1) && arr[low] >= arr[high]){
            return arr[low];
        }

        if((high == low + 1) && arr[low] < arr[high]){
            return arr[high];
        }

        int mid = (low + high) / 2;

        if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]){
            return arr[mid];
        }

        if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
            return findMaximum(arr, low, mid - 1);

        else
            return findMaximum(arr, mid + 1, high);

    }

}

