package com.chenyiwenglish.leetcodejava.easy;

import com.chenyiwenglish.leetcodejava.TreeNode;

public class SortedArrayToBST {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4, 5};
        new Solution().sortedArrayToBST(nums);
    }

    static class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) {
                return null;
            }
            if (nums.length == 1) {
                return new TreeNode(nums[0]);
            }
            return sortedSubArrayToBST(nums, 0, nums.length - 1);
        }

        private TreeNode sortedSubArrayToBST(int[] nums, int left, int right) {
            if (left == right) {
                return new TreeNode(nums[left]);
            }
            if (right - left == 1) {
                TreeNode head = new TreeNode(nums[left]);
                head.right = new TreeNode(nums[right]);
                return head;
            }
            int m = (right + left) / 2;
            TreeNode head = new TreeNode(nums[m]);
            head.left = sortedSubArrayToBST(nums, left, m - 1);
            head.right = sortedSubArrayToBST(nums, m + 1, right);
            return head;
        }
    }

}
