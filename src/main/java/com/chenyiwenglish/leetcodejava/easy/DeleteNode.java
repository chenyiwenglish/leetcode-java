package com.chenyiwenglish.leetcodejava.easy;

import com.chenyiwenglish.leetcodejava.ListNode;

public class DeleteNode {

    class Solution {
        public void deleteNode(ListNode node) {
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
        }
    }
}
