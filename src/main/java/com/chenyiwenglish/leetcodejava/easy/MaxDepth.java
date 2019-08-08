package com.chenyiwenglish.leetcodejava.easy;

import com.chenyiwenglish.leetcodejava.TreeNode;

public class MaxDepth {
    class Solution {

        public int maxDepth(TreeNode root) {
            return visitNode(root);
        }

        private int visitNode(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int lr = visitNode(root.left);
            int rr = visitNode(root.right);
            int max = Math.max(lr, rr);
            return 1 + max;
        }
    }

}
