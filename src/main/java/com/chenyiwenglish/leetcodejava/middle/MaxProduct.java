package com.chenyiwenglish.leetcodejava.middle;

public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = new int[]{0,-3,1,3,-3,-1,2};
        System.out.println(new MaxProduct.Solution().maxProduct(nums));
    }

    static class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return nums[0];
            }
            int[] dp = new int[n];
            int[] dpm = new int[n];
            int max = Integer.MIN_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                dpm[i] = nums[i];
                dp[i] = nums[i];
                if (i < n - 1) {
                    int res = nums[i] * dp[i + 1];
                    int resm = nums[i] * dpm[i + 1];
                    int y = res > resm ? res : resm;
                    int z = res > resm ? resm : res;
                    if (y > dp[i]) {
                        dp[i] = y;
                    }
                    if (z < dpm[i]) {
                        dpm[i] = z;
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
