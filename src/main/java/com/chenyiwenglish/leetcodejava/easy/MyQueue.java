package com.chenyiwenglish.leetcodejava.easy;

public class MyQueue {

    private ListNode head;
    private ListNode top;

    /** Initialize your data structure here. */
    public MyQueue() {
        head = null;
        top = head;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (head == null) {
            head = new ListNode(x);
            top = head;
        } else {
            top.next = new ListNode(x);
            top = top.next;
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int val = head.val;
        head = head.next;
        return val;
    }

    /** Get the front element. */
    public int peek() {
        int val = head.val;
        return val;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return head == null;
    }

    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
