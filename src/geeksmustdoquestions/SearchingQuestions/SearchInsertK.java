package geeksmustdoquestions.SearchingQuestions;

public class SearchInsertK {
    public static void main(String[] args) {

        int[] arr = new int[]{-86 ,-82, -54, -35, -15, 2 ,3, 4, 8, 9, 10, 13, 16, 17};
        int n = arr.length;
        int k = -99;

        System.out.println(searchInsertK(arr, n , k));
    }
    //linear
    static int searchInsertK(int[] arr , int n , int k){
        //searching in a sorted array
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == k){
                return i;
            }
            if(arr[i] > k){
                return i;
            }
        }
        return  n;
    }

    static int searchInsertK2(int[] arr , int n , int k){
        //binary search
        int start = 0;
        int end = n - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] == k){
                return mid;
            }else if(arr[mid] < k){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        // 3 6 7 9
        // inserting 1
        // inserting 4
        // inserting 10
        return end + 1;
    }
}
