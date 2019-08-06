package com.chenyiwenglish.leetcodejava.hard;

import com.chenyiwenglish.leetcodejava.ListNode;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode result = new Solution().reverseKGroup(listNode, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    static class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 0 || k == 1) {
                return head;
            }
            ListNode listNode = head;
            ListNode resHead = null;
            ListNode curHead = null;
            ListNode curTail = null;
            int count = 1;
            while (listNode != null) {
                if (count % k == 1) {
                    curHead = listNode;
                }
                if (count % k == 0) {
                    ListNode[] res = swapPairs(curHead, k);
                    curHead = res[0];
                    if (curTail != null) {
                        curTail.next = curHead;
                    }
                    curTail = res[1];
                    if (resHead == null) {
                        resHead = curHead;
                    }
                }
                count++;
                listNode = listNode.next;
            }
            if ((count - 1) % k != 0) {
                if (curTail != null) {
                    curTail.next = curHead;
                } else {
                    resHead = curHead;
                }
            }
            return resHead;
        }

        public ListNode[] swapPairs(ListNode head, int k) {
            ListNode[] lists = new ListNode[k];
            ListNode listNode = head;
            for (int i = 0; i < k; i++) {
                lists[i] = listNode;
                listNode = listNode.next;
            }
            ListNode resultHead = null;
            ListNode preNode = null;
            for (int i = k - 1; i >= 0; i--) {
                ListNode node = new ListNode(lists[i].val);
                if (resultHead == null) {
                    resultHead = node;
                }
                if (preNode != null) {
                    preNode.next = node;
                }
                preNode = node;
            }
            return new ListNode[]{resultHead, preNode};
        }
    }
}
