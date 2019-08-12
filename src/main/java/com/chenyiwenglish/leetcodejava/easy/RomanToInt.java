package com.chenyiwenglish.leetcodejava.easy;

public class RomanToInt {
    class Solution {

        private String str = "IVXLCDM";
        private int[] vals = new int[]{1, 5, 10, 50, 100, 500, 1000};
        private int[] spVals = new int[]{0, 4, 9, 40, 90, 400, 900};

        public int romanToInt(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); ) {
                int type = getType(s.charAt(i));
                int nextType = -1;
                if (i + 1 < s.length()) {
                    nextType = getType(s.charAt(i + 1));
                    if (nextType > type) {
                        res = res + getSpVal(nextType);
                        i += 2;
                        continue;
                    }
                }
                res = res + getVal(type);
                i++;

            }
            return res;
        }

        private int getType(char c) {
            return str.indexOf(c);
        }

        private int getVal(int type) {
            return vals[type];
        }

        private int getSpVal(int type) {
            return spVals[type];
        }
    }
}
