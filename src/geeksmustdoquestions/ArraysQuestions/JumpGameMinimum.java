package geeksmustdoquestions.ArraysQuestions;

import java.util.Arrays;

public class JumpGameMinimum {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
/*        int n = arr.length;
        System.out.print("Minimum number of jumps to reach end is "
                + minJumps(arr, 0, n - 1));*/
        System.out.println(Arrays.toString(arr));
       // System.out.println(jump(arr));
        System.out.println(jump_3(arr));
    }
    static int minJumps(int arr[] , int l , int h){
        //base case
        if(h == l){
            return 0;
        }

        //when nothing reachable
        //from the given source
        if(arr[l] == 0){
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;

        for(int i = l+1; i<=h && i <= l + arr[l]; i++){
            int jumps = minJumps(arr, i , h);
            if(jumps != Integer.MAX_VALUE && jumps + 1 < min){
                min = jumps + 1;
            }
        }

        return min;
    }

    public static int jump(int[] nums) {
        int min[] = new int[nums.length];
        int j;
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i++) {
            if (i + nums[i] >= nums.length - 1)
                return 1 + min[i];
            j = 1;
            System.out.println("i "+i);
            while (j <= nums[i]) {
                min[j + i] = Math.min( min[j + i], min[i] + 1);
                j++;
            }
            System.out.println(Arrays.toString(min));
        }

        return min[min.length - 1];
    }
    public static int jump_2(int[] A) {
        int currLong = 0, nextLong = 0, level = 0;
        for (int i = 0; i < A.length; i++) {

            if (i - 1 == currLong) {
                level++;
                currLong = nextLong;
            }

            nextLong = Math.max(nextLong, A[i] + i);
            System.out.println("-----i----- "+i+" currLong "+currLong + " nextLong "+ nextLong+" level "+level);
        }
        return level;
    }
    public static int jump_3(int[] A) {
        int step_count = 0;
        int last_jump_max = 0;
        int current_jump_max = 0;
        for (int i = 0; i < A.length - 1; i++) {
            current_jump_max = Math.max(current_jump_max, i + A[i]);
            System.out.println(i+" current_jump_max "+current_jump_max+ " last_jump_max "+last_jump_max+ " steps "+step_count);
            if (i == last_jump_max) {
                step_count++;
                last_jump_max = current_jump_max;
            }
        }
        return step_count;
    }
}
