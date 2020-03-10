package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/10
 * @desc
 */
public class DiameterOfBinaryTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        d(root);
        return max;
    }

    public int d(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = d(root.left);
        int r = d(root.right);
        if (l + r > max) {
            max = l + r;
        }
        l = Math.max(l, r);

        return l + 1;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5};
        TreeNode node = TreeUtil.createTree(nums);
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(node));
    }
}
