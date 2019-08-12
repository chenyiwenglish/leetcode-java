package com.chenyiwenglish.leetcodejava.easy;

import java.util.ArrayList;
import java.util.List;

public class Yanghui {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 1; i <= numRows; i++) {
                result.add(getList(result, i));
            }
            return result;
        }

        private List<Integer> getList(List<List<Integer>> result, int idx) {
            List<Integer> res = new ArrayList<>();
            if (idx == 1) {
                res.add(1);
                return res;
            }
            if (idx == 2) {
                res.add(1);
                res.add(1);
                return res;
            }
            res.add(1);
            List<Integer> preList = result.get(idx - 2);
            for (int i = 1; i < idx - 1; i++) {
                res.add(preList.get(i - 1) + preList.get(i));
            }
            res.add(1);
            return res;
        }
    }
}
//d[m][i] = d[m-1][i -1] + d[m-1][i]