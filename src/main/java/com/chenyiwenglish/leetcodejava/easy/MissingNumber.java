package com.chenyiwenglish.leetcodejava.easy;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(new Solution().missingNumber(nums));
    }

    static class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            nums = resort(nums, 0);
            for (int i = 0; i < n; i++) {
                if (nums[i] == -1) {
                    return i;
                }
            }
            return n;
        }

        private int[] resort(int[] nums, int i) {
            int n = nums.length;
            if (i == n) {
                return nums;
            }
            if (nums[i] == -1) {
                return resort(nums, i + 1);
            }
            if (nums[i] == i) {
                return resort(nums, i + 1);
            }
            if (nums[i] == n) {
                nums[i] = -1;
                return resort(nums, i + 1);
            } else {
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
                return resort(nums, i);
            }
        }
    }
}
