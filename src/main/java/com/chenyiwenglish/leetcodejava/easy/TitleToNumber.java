package com.chenyiwenglish.leetcodejava.easy;

public class TitleToNumber {
    class Solution {
        public int titleToNumber(String s) {
            int sum = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                sum = sum + (s.charAt(i) - 'A' + 1) * xishu(s, i);
            }
            return sum;
        }

        private int xishu(String s, int idx) {
            int res = s.length() - 1 - idx;
            if (res == 0) {
                return 1;
            }
            int multi = 1;
            for (int i = 0; i < res; i++) {
                multi = multi * 26;
            }
            return multi;
        }
    }
}
