package com.chenyiwenglish.leetcodejava.easy;

public class ReverseString {

    public static void main(String[] args) {
        char[] nums = new char[]{'A', ' ', 'm', 'a', 'n', ',', ' ', 'a', ' ', 'p', 'l', 'a', 'n', ',', ' ', 'a', ' ', 'c', 'a', 'n', 'a', 'l', ':', ' ', 'P', 'a', 'n', 'a', 'm', 'a'};
        new Solution().reverseString(nums);
    }

    static class Solution {
        public void reverseString(char[] s) {
            if (s.length == 0) {
                return;
            }
            reverseSubString(s, 0, s.length - 1);
            reverseSubString(s, 0, s.length - 1);
        }

        private void reverseSubString(char[] s, int left, int right) {
            if (right - left <= 2) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                return;
            }
            int m = (left + right) / 2;
            swapSubString(s, left, right);
            if ((right - left) % 2 == 1) {
                reverseSubString(s, left, m);
                reverseSubString(s, m + 1, right);
            } else {
                reverseSubString(s, left, m - 1);
                reverseSubString(s, m + 1, right);
            }
        }

        private void swapSubString(char[] s, int left, int right) {
            int m = (left + right) / 2;
            for (int i = left, j = m + 1; j <= right; i++, j++) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }
        }
    }
}
