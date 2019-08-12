package com.chenyiwenglish.leetcodejava.easy;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
    }

    static class Solution {
        public boolean isHappy(int n) {
            List<Integer> sums = new ArrayList<>();
            while (true) {
                sums.add(n);
                List<Integer> nums = getNums(n);
                int sum = 0;
                for (int i = 0; i < nums.size(); i++) {
                    sum = sum + nums.get(i) * nums.get(i);
                }
                if (sum == 1) {
                    return true;
                }
                if (sums.contains(sum)) {
                    break;
                }
                n = sum;
            }
            return false;
        }

        private List<Integer> getNums(int n) {
            List<Integer> result = new ArrayList<>();
            while (n / 10 != 0) {
                result.add(n % 10);
                n = n / 10;
            }
            result.add(n % 10);
            return result;
        }
    }

}
