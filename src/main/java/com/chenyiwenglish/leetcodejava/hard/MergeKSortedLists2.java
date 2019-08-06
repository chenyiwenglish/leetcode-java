package com.chenyiwenglish.leetcodejava.hard;

import com.chenyiwenglish.leetcodejava.ListNode;

public class MergeKSortedLists2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(11);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(6);
        l3.next = new ListNode(10);
        Solution solution = new Solution();
        ListNode res = solution.mergeKLists(new ListNode[]{l1, l3});
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode head = null;
            ListNode pre = null;
            ListNode node = null;
            while (!isEmpty(lists)) {
                ListNode minNode = null;
                int min = Integer.MAX_VALUE;
                int idx1 = -1;
                int idx2 = -1;
                ListNode headNode = null;
                ListNode preNode = null;
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] == null) {
                        continue;
                    }
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        minNode = lists[i];
                        idx1 = i;
                    }
                }
                headNode = lists[idx1];
                while (idx2 == -1 || idx1 == idx2) {
                    if (lists[idx1] == null) {
                        break;
                    }
                    preNode = lists[idx1];
                    lists[idx1] = lists[idx1].next;
                    idx2 = -1;
                    int min2 = Integer.MAX_VALUE;
                    for (int i = 0; i < lists.length; i++) {
                        if (lists[i] == null) {
                            continue;
                        }
                        if (lists[i].val < min2) {
                            min2 = lists[i].val;
                            minNode = lists[i];
                            idx2 = i;
                        }
                    }
                }
                preNode.next = null;
                node = headNode;
                if (head == null) {
                    head = headNode;
                }
                if (pre != null) {
                    pre.next = node;
                }
                pre = preNode;
                node = preNode.next;
            }
            return head;
        }

        private boolean isEmpty(ListNode[] lists) {
            for (ListNode listNode : lists) {
                if (listNode != null) {
                    return false;
                }
            }
            return true;
        }
    }
}
