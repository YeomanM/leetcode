package com.leetcode;

import java.util.Stack;

/**
 * LowestCommonAncestor
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack ps = new Stack();
        this.getAncestors(root, p, ps);
        Stack qs = new Stack();
        this.getAncestors(root, q, qs);

        TreeNode result = (TreeNode) ps.pop();

        

        return null;
    }

    public boolean getAncestors(TreeNode root, TreeNode find, Stack stack) {
        if (root == null) {
            return false;
        }
        if(root.val == find.val) {
            stack.push(root);
            return true;
        }

        boolean b = false;
        if (root.left != null) {
            b = getAncestors(root.left, find, stack);
            if(b) {
                return true;
            }
        }

        if (root.right != null) {
            b = getAncestors(root.right, find, stack);
            if(b) {
                return true;
            }
        }
        
        return false;

    }
}