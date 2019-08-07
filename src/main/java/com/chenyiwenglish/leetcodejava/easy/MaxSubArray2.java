package com.chenyiwenglish.leetcodejava.easy;

public class MaxSubArray2 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return nums[0];
            }
            int[] dp = new int[n + 1];
            dp[n] = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > dp[i + 1]) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = Integer.MIN_VALUE;
                }
                if (i < n - 1) {
                    int res = dp[i + 1] + nums[i];
                    if (res > dp[i]) {
                        dp[i] = dp[i + 1] + nums[i];
                    }
                }
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            return max;
        }

    }
}
