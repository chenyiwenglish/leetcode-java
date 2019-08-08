package com.chenyiwenglish.leetcodejava.middle;

public class JumpGameI {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(new Solution().canJump(nums));
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length <= 1) {
                return true;
            }
            for (int i = 0; i < nums.length; ) {
                int maxStep = nums[i];
                if (maxStep == 0) {
                    return false;
                }
                int maxIdx = i + maxStep;
                if (maxIdx >= nums.length - 1) {
                    return true;
                }
                int nextIdx = -1;
                int max = -1;
                for (int j = i + 1; j <= maxIdx; j++) {
                    if (j + nums[j] > max) {
                        max = j + nums[j];
                        nextIdx = j;
                    }
                }
                i = nextIdx;
            }
            return false;
        }
    }
}
