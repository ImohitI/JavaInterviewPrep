package geeksmustdoquestions.ArraysQuestions;

public class JumpGame {
    public static void main(String[] args) {
      int  A[] = {1, 2, 0, 3, 0, 0};
        System.out.println(canReach_2(A));
    }
    //---------------O(n^2)------------O(n)--------------------------------------
    static int canReach(int[] A) {
        // code here
        // {1, 2, 0, 3, 0, 0}
        return canJump(A) ? 1 : 0;

    }
    public static boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
    public static boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }
    //-------------------------------------------------------------------------
    static int canReach_2(int[] nums) {
        // code here
        // {1, 2, 0, 3, 0, 0}

        int lasGoodIndexPosition = nums.length-1;
        for(int i = nums.length - 1; i >=0 ; i--){
            if(i + nums[i] >= lasGoodIndexPosition){
                lasGoodIndexPosition = i;
            }
        }
        return lasGoodIndexPosition == 0 ? 1:0;

    }

    static boolean canJump2(int[] nums){

        int n = nums.length;
        int can_reach = 0;
        for(int i = 0; i <= can_reach ; i++){
            if(i == n-1){
                return true;
            }
            can_reach = Math.max(can_reach , i + nums[i]);
        }
        return false;
    }





}
