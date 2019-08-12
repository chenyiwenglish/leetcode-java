package com.chenyiwenglish.leetcodejava.easy;

public class BestTimeBuyStock {

    class Solution {

        private int gmax = 0;

        public int maxProfit(int[] prices) {
            getProfix(prices, 0);
            return gmax;
        }

        private void getProfix(int[] prices, int dayIdx) {
            Integer min = Integer.MAX_VALUE;
            int res = 0;
            int i = dayIdx;
            for (; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                } else {
                    res = -prices[i - 1];
                    break;
                }
            }
            if (i > prices.length - 1) {
                return;
            }
            int nextIdx = i;
            for (; i < prices.length; i++) {
                if (prices[i] + res > gmax) {
                    gmax = prices[i] + res;
                }
            }
            getProfix(prices, nextIdx);
        }
    }
}

// find lowest
// sell before go down
