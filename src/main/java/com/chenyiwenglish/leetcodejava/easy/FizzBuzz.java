package com.chenyiwenglish.leetcodejava.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                StringBuilder str = new StringBuilder();
                if (i % 3 == 0) {
                    str.append("Fizz");
                }
                if (i % 5 == 0) {
                    str.append("Buzz");
                }
                if (str.toString().isEmpty()) {
                    res.add(String.valueOf(i));
                } else {
                    res.add(str.toString());
                }
            }
            return res;
        }
    }
}
