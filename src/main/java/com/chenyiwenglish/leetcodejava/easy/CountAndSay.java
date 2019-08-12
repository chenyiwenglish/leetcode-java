package com.chenyiwenglish.leetcodejava.easy;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(6));
    }

    static class Solution {
        public String countAndSay(int n) {
            return countSubAndSay(n);
        }


        private String countSubAndSay(int n) {
            if (n == 1) {
                return "1";
            } else {
                return countSubAndSay(countSubAndSay(n - 1));
            }
        }

        private String countSubAndSay(String str) {
            List<CountTarget> orderList = new ArrayList<>();
            int j = 0;
            for (int i = 0; i < str.length(); i++) {
                int key = Integer.parseInt(String.valueOf(str.charAt(i)));
                if (i == 0) {
                    CountTarget target = new CountTarget();
                    target.num = key;
                    target.count = 1;
                    orderList.add(target);
                    j++;
                } else {
                    int preKey = Integer.parseInt(String.valueOf(str.charAt(i - 1)));
                    if (key == preKey) {
                        orderList.get(j - 1).count++;
                    } else {
                        CountTarget target = new CountTarget();
                        target.num = key;
                        target.count = 1;
                        orderList.add(target);
                        j++;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < orderList.size(); i++) {
                sb.append(orderList.get(i).count).append(orderList.get(i).num);
            }
            return sb.toString();
        }

        class CountTarget {
            public Integer num;
            public Integer count;
        }
    }
}
