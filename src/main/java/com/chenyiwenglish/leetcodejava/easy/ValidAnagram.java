package com.chenyiwenglish.leetcodejava.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<String, Integer> scount = getCount(s);
            Map<String, Integer> tcount = getCount(t);
            if (scount.size() != tcount.size()) {
                return false;
            }
            for (Map.Entry<String, Integer> entry : scount.entrySet()) {
                if (!tcount.containsKey(entry.getKey())) {
                    return false;
                }
                if (!tcount.get(entry.getKey()).equals(entry.getValue())) {
                    return false;
                }
            }
            return true;
        }

        private Map<String, Integer> getCount(String s) {
            Map<String, Integer> result = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (result.containsKey(String.valueOf(s.charAt(i)))) {
                    result.put(String.valueOf(s.charAt(i)), result.get(String.valueOf(s.charAt(i))) + 1);
                } else {
                    result.put(String.valueOf(s.charAt(i)), 1);
                }
            }
            return result;
        }
    }
}
