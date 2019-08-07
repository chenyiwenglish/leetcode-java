package com.chenyiwenglish.leetcodejava.easy;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
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
            int max = Integer.MIN_VALUE;
            int[][] dp = new int[n][n];
            for (int i = n - 2; i >= 0; i--) {
                dp[i][i] = nums[i];
                if (dp[i][i] > max) {
                    max = dp[i][i];
                }
                for (int j = i + 1; j < n; j++) {
                    dp[j][j] = nums[j];
                    if (dp[j][j] > max) {
                        max = dp[j][j];
                    }
                    int res = sum(nums, i + 1, j, dp) + dp[i][i];
                    dp[i][j] = res;
                    if (res > max) {
                        max = res;
                    }
                }
            }
            return max;
        }

        private int sum(int[] nums, int start, int end, int[][] dp) {
            if (start == end) {
                return dp[start][start];
            } else {
                int res = dp[start][end - 1] + nums[end];
                dp[start][end] = res;
                return res;
            }
        }
    }
}
