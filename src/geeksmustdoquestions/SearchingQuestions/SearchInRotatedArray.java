package geeksmustdoquestions.SearchingQuestions;

public class SearchInRotatedArray {
    public static void main(String[] args) {

    }

    static int search(int array[] , int target){
        int n = array.length;
        int low = 0 , high = n-1 , ans = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(target == array[mid]){
                ans = mid;
                break;
            }

            if(array[low] <= array[mid]){
                if(array[low] <= target && target <= array[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else{
                if(array[mid] < array[high]){
                    if(array[mid] <= target && target <= array[high]){
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }
                }
            }
        }
        return ans;
    }
}
