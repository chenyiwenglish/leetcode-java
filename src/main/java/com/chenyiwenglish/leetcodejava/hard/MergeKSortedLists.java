package com.chenyiwenglish.leetcodejava.hard;

import com.chenyiwenglish.leetcodejava.ListNode;

public class MergeKSortedLists {

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode head = null;
            ListNode pre = null;
            ListNode node = null;
            while (!isEmpty(lists)) {
                ListNode minNode = null;
                int min = Integer.MAX_VALUE;
                int idx = -1;
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] == null) {
                        continue;
                    }
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        minNode = lists[i];
                        idx = i;
                    }
                }
                node = new ListNode(minNode.val);
                if (head == null) {
                    head = node;
                }
                if (pre != null) {
                    pre.next = node;
                }
                pre = node;
                node = node.next;
                lists[idx] = lists[idx].next;
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
