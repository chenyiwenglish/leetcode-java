package com.chenyiwenglish.leetcodejava.middle;

public class LongestPalindrome1 {

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
            for (int i = n - 2; i >= 0; i--) {
                dp[i][i] = true;
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        if (j == i + 1) {
                            dp[i][j] = true;
                        } else if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = false;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                    if (dp[i][j]) {
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
    }

//    d[i][j] :
//    i=j true
//    i-1 = j+1 & d[i][j]
}
