package com.chenyiwenglish.leetcodejava.easy;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private int min = Integer.MAX_VALUE;

    private List<Integer> list;

    private int top;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        list = new ArrayList<>();
        top = -1;
    }

    public void push(int x) {
        list.add(x);
        top++;
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        if (top != -1) {
            int val = list.get(top);
            list.remove(top);
            top--;
            if (val == min) {
                min = Integer.MAX_VALUE;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) < min) {
                        min = list.get(i);
                    }
                }
            }
        }
    }

    public int top() {
        return list.get(top);
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
