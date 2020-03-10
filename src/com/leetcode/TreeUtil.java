package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * CreateTree
 */
public class TreeUtil {

    public static TreeNode createTree(Integer[] trees) {
        
        TreeNode parent = null;
        if (trees != null && trees.length > 0) {
            parent = new TreeNode(trees[0]);
            createTree(parent, 0, trees);
        }
        return parent;
    }

    private static void createTree(TreeNode parent, int pId, Integer[] nums) {
        int len = nums.length;
        if ((pId << 1) + 1 < len && nums[(pId << 1) + 1] != null) {
            TreeNode node = new TreeNode(nums[(pId << 1) + 1]);
            parent.left = node;
            createTree(node, (pId << 1) + 1, nums);
        } 

        if ((pId << 1) + 2 < len && nums[(pId << 1) + 2] != null) {
            TreeNode node = new TreeNode(nums[(pId << 1) + 2]);
            parent.right = node;
            createTree(node, (pId << 1) + 2, nums);
        } 
    }
}