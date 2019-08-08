package com.chenyiwenglish.leetcodejava.easy;

public class ClimbStairs {

    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                if (i <= 2) {
                    dp[i] = i;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
            return dp[n];
        }
    }
}
//dp[i]=dp[i-1]+dp[i-2]
