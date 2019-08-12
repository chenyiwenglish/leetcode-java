package com.chenyiwenglish.leetcodejava.easy;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};
        System.out.println(new Solution().singleNumber(nums));
    }

    // 异或
    static class Solution {
        public int singleNumber(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = sum ^ nums[i];
            }
            return sum;
        }
    }
}

