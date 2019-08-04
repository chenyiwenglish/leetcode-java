package com.chenyiwenglish.leetcodejava.middle;

public class LongestPalindrome {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc";
        long t = System.currentTimeMillis();
        String longestPalindrome = solution.longestPalindrome(s);
        System.out.println(System.currentTimeMillis() - t);
        System.out.println(longestPalindrome);
    }

    static class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n == 0) {
                return "";
            }
            int max = 0;
            int maxi = 0;
            int maxj = 0;
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i ++) {
                for (int j = n - 1; j >= i; j --) {
                    if (isPalindrome(s, i, j, dp)) {
                        if (j - i > max) {
                            max = j - i;
                            maxi = i;
                            maxj = j;
                        }
                    }
                }
            }
            return s.substring(maxi, maxj + 1);
        }

        private boolean isPalindrome(String s, int i, int j, boolean[][] dp) {
            if (i > j) {
                return dp[i][j];
            }
            if (i == j) {
                dp[i][j] = true;
                dp[j][i] = true;
                return true;
            }
            if (s.charAt(i) != s.charAt(j)) {
                dp[i][j] = false;
                dp[j][i] = false;
                return false;
            }
            if (j == i + 1) {
                dp[i][j] = true;
                return true;
            }
            if (dp[i + 1][j - 1]) {
                dp[i][j] = true;
                dp[j][i] = true;
                return true;
            }
            if (isPalindrome(s, i + 1, j - 1, dp)) {
                dp[i][j] = true;
                dp[j][i] = true;
                return true;
            }
            dp[i][j] = false;
            dp[j][i] = false;
            return false;
        }
    }

//    d[i][j] :
//    i=j true
//    i-1 = j+1 & d[i][j]
}
