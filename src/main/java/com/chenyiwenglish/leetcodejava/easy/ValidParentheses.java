package com.chenyiwenglish.leetcodejava.easy;

import java.util.LinkedList;
import java.util.List;

public class ValidParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "[{[{[]}]}{[]}{[{[]}]}{[]}{[{[]}]}{[]}]}";
        System.out.println(solution.isValid(s));
    }

    static class Solution {
        public boolean isValid(String s) {
            if (s.length() == 0) {
                return true;
            }
            Stack stack = new Stack();
            return isSubStringValid(s, 0, stack);
        }

        private boolean isSubStringValid(String s, int i, Stack stack) {
            if (i >= s.length()) {
                return stack.empty();
            }
            if (stack.empty()) {
                if (!addType(s.charAt(i), stack)) {
                    return false;
                }
                return isSubStringValid(s, i + 1, stack);
            }
            if (matchType(s.charAt(i), stack.getTop())) {
                stack.pop();
                return isSubStringValid(s, i + 1, stack);
            } else {
                if (!addType(s.charAt(i), stack)) {
                    return false;
                }
                return isSubStringValid(s, i + 1, stack);
            }
        }

        private boolean addType(char c, Stack stack) {
            if (c == '(') {
                // 用stack来保存type
                stack.push(0);
            } else if (c == '{') {
                stack.push(1);
            } else if (c == '[') {
                stack.push(2);
            } else {
                return false;
            }
            return true;
        }

        private boolean matchType(char c, int type) {
            if (type == 0) {
                return c == ')';
            } else if (type == 1) {
                return c == '}';
            } else if (type == 2) {
                return c == ']';
            }
            return false;
        }

        static class Stack {
            private int top;
            private List<Integer> items;

            public Stack() {
                items = new LinkedList<>();
                top = -1;
            }

            public boolean empty() {
                return items.isEmpty();
            }

            public void push(int item) {
                items.add(item);
                top = top + 1;
            }

            public void pop() {
                items.remove(top);
                top = top - 1;
            }

            public int getTop() {
                return items.get(top);
            }
        }
    }
}
