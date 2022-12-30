package LeetCode100;

import java.util.Arrays;

public class _001TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int z = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                z = nums[i] + nums[j];
                if (z == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
