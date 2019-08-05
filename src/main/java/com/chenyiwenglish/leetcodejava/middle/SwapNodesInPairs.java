package com.chenyiwenglish.leetcodejava.middle;

import com.chenyiwenglish.leetcodejava.ListNode;

public class SwapNodesInPairs {

    class Solution {
        public  ListNode swapPairs(ListNode head) {
            ListNode listNode = head;
            ListNode preNode = null;
            ListNode first = head;
            while (listNode != null) {
                ListNode sufNode = listNode.next;
                if (sufNode == null) {
                    break;
                }
                if (preNode != null) {
                    preNode.next = sufNode;
                } else {
                    first = head.next;
                }
                listNode.next = sufNode.next;
                sufNode.next = listNode;
                preNode = listNode;
                listNode = listNode.next;
            }
            return first;
        }
    }
}
