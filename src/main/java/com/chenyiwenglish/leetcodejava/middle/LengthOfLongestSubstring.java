package com.chenyiwenglish.leetcodejava.middle;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }

   static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.isEmpty()) {
                return 0;
            }
            int max = 1;
            int n = s.length();
            for (int i = n - 2; i >= 0; i --) {
                Set<String> set = new HashSet<>();
                set.add(String.valueOf(s.charAt(i)));
                for (int p = 1; i + p < n; p ++) {
                    set.add(String.valueOf(s.charAt(i + p)));
                    int length = p + 1;
                    if (set.size() == length) {
                        if (length > max) {
                            max = length;
                        }
                    } else {
                        break;
                    }
                }
            }
            return max;
        }

    }
}
