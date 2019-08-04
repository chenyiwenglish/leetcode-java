package com.chenyiwenglish.leetcodejava.easy;

public class MergeSortedArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {7, 9, 10, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] loc = new int[m + n];
            int i = 0;
            int j = 0;
            int p = 0;
            for (; p < m + n; p++) {
                if (i >= m || j >= n) {
                    break;
                }
                if (nums2[j] < nums1[i]) {
                    loc[p] = nums2[j];
                    j++;
                } else {
                    loc[p] = nums1[i];
                    i++;
                }
            }
            if (i != m) {
                for (; p < m + n; p++, i++) {
                    loc[p] = nums1[i];
                }
            }
            if (j != n) {
                for (; p < m + n; p++, j++) {
                    loc[p] = nums2[j];
                }
            }
            for (int q = 0; q < loc.length; q++) {
                nums1[q] = loc[q];
            }
        }
    }
}
