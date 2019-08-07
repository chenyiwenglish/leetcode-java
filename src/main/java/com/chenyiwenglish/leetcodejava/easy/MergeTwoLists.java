package com.chenyiwenglish.leetcodejava.easy;

import com.chenyiwenglish.leetcodejava.ListNode;

public class MergeTwoLists {

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode newHead = null;
            ListNode curNode = null;
            while (l1 != null && l2 != null) {
                ListNode listNode;
                if (l1.val < l2.val) {
                    listNode = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    listNode = new ListNode(l2.val);
                    l2 = l2.next;
                }
                if (newHead == null) {
                    newHead = listNode;
                }
                if (curNode != null) {
                    curNode.next = listNode;
                }
                curNode = listNode;
            }
            while (l1 != null) {
                ListNode listNode = new ListNode(l1.val);
                if (newHead == null) {
                    newHead = listNode;
                }
                if (curNode != null) {
                    curNode.next = listNode;
                }
                curNode = listNode;
                l1 = l1.next;
            }
            while (l2 != null) {
                ListNode listNode = new ListNode(l2.val);
                if (newHead == null) {
                    newHead = listNode;
                }
                if (curNode != null) {
                    curNode.next = listNode;
                }
                curNode = listNode;
                l2 = l2.next;
            }
            return newHead;
        }
    }
}
