package geeksmustdoquestions;

public class MaximumNo1s {
    public static void main(String[] args) {
        int arr[] = {1,1,1,1,1, 0, 0, 0,0,0, 1, 1,0, 0,0 , 0, 1};
        int m = 2;

       //  int arr[] = {1, 1, 1, 1,1, 0, 0, 1, 0, 0, 9};
       //   int m = 3;
       // int arr[] = {0,1,1,1,1,0,0,1,1,0,1,0,1,1,0,0,0,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,0,1,1,1,0,1,0,1,1,1,1,0,1,0,0,1,0,1,0,1,0,0,1,0,0,0,1,1,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,0,1,0,1,0,0,0,0};
       // int m = 60;
 /*
        84
        0 1 1 1 1 0 0 1 1 0 1 0 1 1 0 0 0 0 0 1 0 1 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 1 0 1 1 1 1 0 1 0 0 1 0 1 0 1 0 0 1 0 0 0 1 1 1 0 1 0 1 0 1 1 1 0 1 0 1 0 1 0 0 1 0 1 0 0 0 0
        60
        */
        findZeroes_2(arr, m);
    }

    // m is maximum of number zeroes allowed to flip
    static int findZeroes(int arr[], int m) {
        // code here
       // int maxSum = 0;
        int zeroCount = 0;
        int max = 0 ;
        for (int i = 0; i < arr.length; i++) {
            zeroCount = 0;
            for (int j = i; j < arr.length; j++) {
                if(zeroCount >=m && arr[j] == 1 ){
                    max = Math.max(max , j-i+1);
                }else if(zeroCount >= m && arr[j] == 0){
                    max = Math.max(max , j-i);
                    break;
                }else if(zeroCount < m && j == (arr.length-1)){
                    max = Math.max(max , j-i+1);
                }else if(arr[j] == 0){
                    zeroCount++;

                }
            }
        }
        System.out.println("Max subArray "+max);
        return max;
    }
    //nsdrdun
    //{1, 0, 0, 0, 1, 1,0, 0,0 , 1, 0, 1, 1, 1};
    static int findZeroes_2(int arr[], int m) {
        // code here
        // int maxSum = 0;
        int zeroCount = 0;
        int max = 0 ;
        int start = 0, end = 0;
        while(start <= end && end < arr.length ){

            if(arr[end] == 0){
                zeroCount++;
            }
            System.out.println("start "+start+ " end "+end+" zeroCount "+zeroCount);
            if(zeroCount <= m){
                //max = Math.max(max , end - start +1);
            }else {
                if(arr[start] == 0){
                    zeroCount--;
                }
                start++;
            }
            end++;
        }
        System.out.println("Max subArray "+(end-start));
        return end-start;
    }
    //
    //{1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
    static int findZeroes_3(int A[], int K) {
        int i = 0;
        int j = 0;

        while( i< A.length){

            if(A[i] == 0) K--;
            if(K < 0 ){
                if(A[j] == 0){
                    K++;
                }

                j++;
            }


            i++;
        }

        return i-j;
    }
}
