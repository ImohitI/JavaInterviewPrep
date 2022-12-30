package LeetCode100;

import java.util.*;

public class _026RemDupSortArray {
    public int removeDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int x : nums) {
            if (res.isEmpty() || !res.get(res.size() - 1).equals(x)) {
                res.add(x);
            }
        }

        // int[] result = res.stream().mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < res.size(); i++) {
            nums[i] = res.get(i);
        }

        return res.size();
    }

    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int x : nums) {
            if (i == 0 || x > nums[i - 1]) {
                nums[i++] = x;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        int answer = new _026RemDupSortArray().removeDuplicates1(nums);
        System.out.println(Arrays.toString(nums));
    }
}