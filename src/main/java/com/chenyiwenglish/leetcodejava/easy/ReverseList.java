package com.chenyiwenglish.leetcodejava.easy;

import com.chenyiwenglish.leetcodejava.ListNode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode listNode = head;
        int length = 0;
        while (listNode != null) {
            length ++;
            listNode = listNode.next;
        }
        ListNode[] lists = new ListNode[length];
        listNode = head;
        for (int i = 0; i < length; i++) {
            lists[i] = listNode;
            listNode = listNode.next;
        }
        ListNode resultHead = null;
        ListNode preNode = null;
        for (int i = length - 1; i >= 0; i--) {
            ListNode node = new ListNode(lists[i].val);
            if (resultHead == null) {
                resultHead = node;
            }
            if (preNode != null) {
                preNode.next = node;
            }
            preNode = node;
        }
        return resultHead;
    }
}
