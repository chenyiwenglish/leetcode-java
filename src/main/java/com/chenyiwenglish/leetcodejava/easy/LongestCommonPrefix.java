package com.chenyiwenglish.leetcodejava.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"f"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            int min = Integer.MAX_VALUE;
            if (strs.length == 0) {
                return "";
            }
            for (String str : strs) {
                if (str.length() < min) {
                    min = str.length();
                }
            }
            if (min == 0) {
                return "";
            }
            char first = strs[0].charAt(0);
            for (String str : strs) {
                if (str.charAt(0) != first) {
                    return "";
                }
            }
            for (int i = 1; i < min; i++) {
                char c = strs[0].charAt(i);
                for (String str : strs) {
                    if (str.charAt(i) != c) {
                        return str.substring(0, i);
                    }
                }
            }
            return strs[0].substring(0, min);
        }
    }
}

//dp[i] = dp[i-1] + charat i equals
//dp[0] = ''