package com.chenyiwenglish.leetcodejava.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            return Arrays.stream(nums).distinct().count() != nums.length;
        }
    }
}
