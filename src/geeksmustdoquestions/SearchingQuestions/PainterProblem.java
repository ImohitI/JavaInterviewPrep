package geeksmustdoquestions.SearchingQuestions;

public class PainterProblem {
    /*
    Another interpretation ::
    Divide an array of size N into K subArrays such that sum of max-valued subArray is minimum
     */
    public static void main(String[] args) {
        int arr[] = { 10, 20, 60, 50, 30, 40 };
        int k = 3;
        // N * N * N ... k times
        // time O(n^k)

       // System.out.println(partition( arr , arr.length , k));
        System.out.println(findMax(arr,arr.length,k));
    }
    //n boards and k partitions
    static int partition(int arr[] , int n , int k){
        //base cases
        if(k == 1){ // one partition
            return sum(arr , 0 , n-1);
        }
        if(n == 1){ // one board
            return arr[0];
        }

        int best = Integer.MAX_VALUE;
        /*
         find minimum of all possible maximum
         k-1 partitions to the left of arr[i]
         with i elements, put k-1 th divider
         between arr[i-1] & arr[i] to get kth partition
         */
        for(int i = 1; i <= n ; i++){
            best = Math.min(best , Math.max(partition(arr , i , k-1), sum(arr , i , n-1)));
        }
        return best;
    }
    //common method -- sum the element in the array starting from one index to another
    static int sum(int arr[] , int from , int to){
        int total = 0;

        if(from > to){
            System.out.println("from "+from+" to "+to);
        }
        for(int i = from ; i <= to ; i++){
            total += arr[i];
        }
        return total;
    }
    // dp -- bottom up tabular dp
    static int findMax(int arr[] , int n , int k){
        //initialize table
        int dp[][] = new int[k+1][n+1];

        //base cases
        // k = 1
        for(int i = 1; i <= n ; i++){
            dp[1][i] = sum(arr , 0 , i-1);
        }

        // n = 1
        for(int i = 1; i <= k ; i++){
            dp[i][1] = arr[0];
        }

        // 2 to k partitions
        for(int i = 2 ; i <= k; i++){
            for(int j = 2 ; j  <= n ; j++){
                System.out.println("processing "+i+","+j);
                //track minimum
                int best = Integer.MAX_VALUE;

                //i-1 th separator before position arr[p=1 .. j]
                for(int p = 1; p <= j ; p++){
                    best = Math.min(best , Math.max(dp[i-1][p], sum(arr , p , j-1)));
                }

                dp[i][j] = best;
                printArray2d(dp);
            }
        }
        return dp[k][n];
    }

    public static void printArray2d(int[][] dp){
        for(int i=0; i< dp.length ; i++){
            for(int j= 0; j < dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }
}
