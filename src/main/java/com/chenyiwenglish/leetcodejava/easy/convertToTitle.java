package com.chenyiwenglish.leetcodejava.easy;

public class convertToTitle {

    class Solution {
        public String convertToTitle(int n) {
            String str = "";
            for (int i = n; i > 0; i = (i - 1) / 26) {
                int val = (i - 1) % 26;
                str = ((char) ('A' + val)) + str;
            }
            return str;
        }
    }
}
