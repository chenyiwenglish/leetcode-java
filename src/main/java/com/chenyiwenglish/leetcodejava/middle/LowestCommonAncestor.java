package com.chenyiwenglish.leetcodejava.middle;

import com.chenyiwenglish.leetcodejava.TreeNode;

public class LowestCommonAncestor {

    class Solution {

        private boolean visitedP = false;
        private boolean visitedQ = false;
        private boolean accessPQ = false;
        private boolean pVisited = false;
        private boolean qVisited = false;
        private boolean qpAccess = false;

        private TreeNode res = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            checkAccess(p, q);
            checkAccess(q, p);
            visitNode(root, p, q);
            return res;
        }

        private void checkAccess(TreeNode node, TreeNode childNode) {
            if (node == null) {
                return;
            }
            checkAccess(node.left, childNode);
            checkAccess(node.right, childNode);
            if (node.val == childNode.val) {
                accessPQ = true;
            }
        }


        private void visitNode(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) {
                return;
            }
            visitNode(node.left, p, q);
            visitNode(node.right, p, q);
            if (node.val == p.val) {
                visitedP = true;
            }
            if (node.val == q.val) {
                visitedQ = true;
            }
            if (res == null && visitedQ && visitedP && accessPQ) {
                res = node;
            }
            if (res == null && visitedQ && visitedP && !accessPQ) {
                pVisited = false;
                qVisited = false;
                checkAccessBoth(node, p, q);
                if (qpAccess) {
                    res = node;
                }
            }

        }

        private void checkAccessBoth(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) {
                return;
            }
            checkAccessBoth(node.left, p, q);
            checkAccessBoth(node.right, p, q);
            if (node.val == p.val) {
                pVisited = true;
            }
            if (node.val == q.val) {
                qVisited = true;
            }
            if (pVisited && qVisited && res == null) {
                qpAccess = true;
            }
        }
    }
}
