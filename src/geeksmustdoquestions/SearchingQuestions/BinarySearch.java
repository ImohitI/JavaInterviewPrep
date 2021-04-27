package geeksmustdoquestions.SearchingQuestions;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2 , 4 , 5 , 6 , 8 , 9};
        System.out.println(binarySearch(arr , 6 , 8));
    }
    static int binarySearch(int arr[], int n , int k){
        int start = 0;
        int end = n-1;

        while(start < end){
            int mid = (start + end)/2;
            if(arr[mid] == k){
                return mid;
            }else if( arr[mid] < k){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
