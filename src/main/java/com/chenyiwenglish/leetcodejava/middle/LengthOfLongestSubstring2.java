package com.chenyiwenglish.leetcodejava.middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring2 {


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
           Map<Character, Integer> map = new HashMap<>();
           int left = 0;
           for (int j = 0; j < n; j++) {
               if (map.containsKey(s.charAt(j))) {
                   int pre = map.get(s.charAt(j));
                   left = Math.max(left, pre + 1);
               }
               map.put(s.charAt(j), j);
               if (j - left + 1 > max) {
                   max = j - left + 1;
               }
           }
           return max;
       }
   }
}
