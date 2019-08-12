package com.chenyiwenglish.leetcodejava.easy;

public class BestTimeBuyStockII {

    class Solution {
        public int maxProfit(int[] prices) {
            return getProfix(prices, 0);
        }

        private int getProfix(int[] prices, int dayIdx) {
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
                return 0;
            }
            int max = prices[i];
            for (; i < prices.length; i++) {
                if (prices[i] >= max) {
                    max = prices[i];
                } else {
                    res = res + prices[i - 1];
                    break;
                }
                if (i == prices.length - 1) {
                    res = res + prices[i];
                }
            }
            res += getProfix(prices, i);
            return res;
        }
    }
}

// find lowest
// sell before go down
