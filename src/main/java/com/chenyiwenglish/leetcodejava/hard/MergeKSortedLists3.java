package com.chenyiwenglish.leetcodejava.hard;

import com.chenyiwenglish.leetcodejava.ListNode;

public class MergeKSortedLists3 {

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            return mergeK(lists, 0, lists.length - 1);
        }

        private ListNode mergeK(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            int middle = (left + right) / 2;
            if (left == middle) {
                return merge2(lists[left], lists[right]);
            }
            ListNode leftNode = mergeK(lists, left, middle);
            ListNode rightNode = mergeK(lists, middle + 1, right);
            return merge2(leftNode, rightNode);
        }

        private ListNode merge2(ListNode left, ListNode right) {
            ListNode listNode;
            ListNode preNode = null;
            ListNode head = null;
            while (left != null && right != null) {
                if (left.val > right.val) {
                    listNode = new ListNode(right.val);
                    right = right.next;
                } else {
                    listNode = new ListNode(left.val);
                    left = left.next;
                }
                if (head == null) {
                    head = listNode;
                }
                if (preNode != null) {
                    preNode.next = listNode;
                }
                preNode = listNode;
                listNode = listNode.next;
            }
            while (left != null) {
                listNode = new ListNode(left.val);
                left = left.next;
                if (head == null) {
                    head = listNode;
                }
                if (preNode != null) {
                    preNode.next = listNode;
                }
                preNode = listNode;
                listNode = listNode.next;
            }
            while (right != null) {
                listNode = new ListNode(right.val);
                right = right.next;
                if (head == null) {
                    head = listNode;
                }
                if (preNode != null) {
                    preNode.next = listNode;
                }
                preNode = listNode;
                listNode = listNode.next;
            }
            return head;
        }
    }
}
