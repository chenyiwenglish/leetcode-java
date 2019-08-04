package com.chenyiwenglish.leetcodejava.middle;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode result = solution.addTwoNumbers(l1, l2);
        do {
            System.out.println(result.val);
            result = result.next;
        } while (result != null);
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode result = null;
            ListNode head = null;
            boolean isAdd = false;
            while (l1 != null) {
                if (l2 != null) {
                    int step = 0;
                    if (isAdd) {
                        step = 1;
                    }
                    int res;
                    if (l1.val + l2.val + step >= 10) {
                        isAdd = true;
                        res = (l1.val + l2.val + step) % 10;
                    } else {
                        isAdd = false;
                        res = l1.val + l2.val + step;
                    }
                    if (result == null) {
                        result = new ListNode(res);
                        head = result;
                    } else {
                        result.next = new ListNode(res);
                        result = result.next;
                    }
                    l2 = l2.next;
                } else {
                    break;
                }
                l1 = l1.next;
            }
            if (l2 == null) {
                while (l1 != null) {
                    int step = 0;
                    if (isAdd) {
                        step = 1;
                    }
                    int res = 0;
                    if (l1.val + step >= 10) {
                        isAdd = true;
                        res = (l1.val + step) % 10;
                    } else {
                        isAdd = false;
                        res = l1.val + step;
                    }
                    result.next = new ListNode(res);
                    result = result.next;
                    l1 = l1.next;
                }
            } else {
                while (l2 != null) {
                    int step = 0;
                    if (isAdd) {
                        step = 1;
                    }
                    int res = 0;
                    if (l2.val + step >= 10) {
                        isAdd = true;
                        res = (l2.val + step) % 10;
                    } else {
                        isAdd = false;
                        res = l2.val + step;
                    }
                    result.next = new ListNode(res);
                    result = result.next;
                    l2= l2.next;
                }
            }
            if (isAdd) {
                result.next = new ListNode(1);
            }
            return head;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
