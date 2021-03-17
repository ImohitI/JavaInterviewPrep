package geeksmustdoquestions;

public class MaximumNo1s {
    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int m = 2;
        findZeroes(arr, m);
    }

    // m is maximum of number zeroes allowed to flip
    static int findZeroes(int arr[], int m) {
        // code here
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                System.out.print("i "+i+"  j "+j+" sum "+sum +" maxsum "+maxSum);
                if ((j - i + 1) <= m) {
                    sum = j - i + 1;
                } else {
                    int increase = (j - i + 1 - sum) >= m ? m : (j - i + 1 - sum);
                    System.out.println(" increase "+increase);
                    sum = sum + increase;
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        System.out.println("Max subArray "+maxSum);
        return maxSum;
    }
}
