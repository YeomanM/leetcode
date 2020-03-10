package com.leetcode;

import java.util.Stack;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/1/22
 * @desc
 */
public class CountNodes {

    public int countNodes(TreeNode root){

        int result = 0;

        if (root != null){

            Stack<TreeNode> queue = new Stack<>();
            queue.push(root);

            while (!queue.isEmpty()) {
                root = queue.pop();
                result++;
                if (root.right != null) {
                    queue.add(root.right);
                }
                if (root.left != null) {
                    queue.add(root.left);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6};
        System.out.println(new CountNodes().countNodes(TreeUtil.createTree(nums)));
    }

}
