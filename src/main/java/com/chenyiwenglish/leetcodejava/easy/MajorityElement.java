package com.chenyiwenglish.leetcodejava.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    class Solution {
        public int majorityElement(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            Map<Integer, Integer> countMap = new HashMap<>();
            int limit = n / 2;
            for (int i = 0; i < nums.length; i++) {
                if (countMap.containsKey(nums[i])) {
                    int res = countMap.get(nums[i]) + 1;
                    if (res > limit) {
                        return nums[i];
                    }
                    countMap.put(nums[i], countMap.get(nums[i]) + 1);
                } else {
                    countMap.put(nums[i], 1);
                }
            }
            return 0;
        }
    }
}
