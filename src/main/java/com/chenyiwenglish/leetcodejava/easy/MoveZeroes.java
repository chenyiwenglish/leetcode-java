package com.chenyiwenglish.leetcodejava.easy;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int count = 0;
            int[] zeroIdxs = new int[nums.length];
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    count++;
                    zeroIdxs[j] = i;
                    j++;
                }
            }
            for (int k = 0; k < j; k++) {
                if (k + 1 < j) {
                    move(nums, zeroIdxs[k] + 1, zeroIdxs[k + 1] - 1, k + 1);
                } else {
                    move(nums, zeroIdxs[k] + 1, nums.length - 1, k + 1);
                }
            }
            for (int l = 0; l < j; l++) {
                nums[nums.length - 1 - l] = 0;
            }
        }

        private void move(int[] nums, int start, int end, int step) {
            for (int i = start; i <= end; i++) {
                nums[i - step] = nums[i];
            }
        }
    }
}
