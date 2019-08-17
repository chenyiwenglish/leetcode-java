package com.chenyiwenglish.leetcodejava.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Map<Integer, Integer> list = new HashMap<>();
            for (int i = 0; i < nums.length; i ++) {
                if (list.containsKey(nums[i])) {
                    return true;
                } else {
                    list.put(nums[i], nums[i]);
                }
            }
            return false;
        }
    }
}
