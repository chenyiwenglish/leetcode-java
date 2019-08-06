package com.chenyiwenglish.leetcodejava.hard;

public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(new Solution().jump(nums));
    }

    static class Solution {
        public int jump(int[] nums) {
            if (nums.length <= 1) {
                return 0;
            }
            return jump(nums, 0);
        }

        private int jump(int[] nums, int i) {
            int maxStep = nums[i];
            if (maxStep == 0) {
                return -Integer.MAX_VALUE;
            }
            int maxIdx = i + maxStep;
            if (maxIdx >= nums.length - 1) {
                return 1;
            }
            int nextIdx = -1;
            int max = -1;
            for (int j = i + 1; j <= maxIdx; j++) {
                if (j + nums[j] > max) {
                    max = j + nums[j];
                    nextIdx = j;
                }
            }
            return 1 + jump(nums, nextIdx);
        }
    }
}
