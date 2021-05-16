package geeksmustdoquestions.SearchingQuestions;

public class BinarySearchInForest {
    public static void main(String[] args) {

    }

    static int woodCollected(int tree[] , int n , int h){
        int ret = 0;

        //counting the amount of wood that gets collected
        //if we cut trees at the height h
        for(int i=0; i<n ; i++){
            if(tree[i] > h){
                ret += tree[i] - h;
            }
        }
        return ret;
    }

    static int findHeight(int tree[] , int n , int k){
        int l = 0;
        int h = 0;

        for(int i=0; i < n; i++){
            if(tree[i] > h){
                h = tree[i];
            }
        }
        while(l <= h){
            int mid = (l+h) / 2;
            int val = woodCollected(tree, n , mid);

            if(val == k) return mid;
            if(val > k) {
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }
        return -1;
    }
}
