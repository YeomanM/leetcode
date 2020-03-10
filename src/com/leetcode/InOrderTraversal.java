package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description :
 * ---------------------------------
 * @Author : Yeoman
 * @Date : Create in 2019/8/16
 */
public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new InOrderTraversal().inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        do {
            if (root.left == null) {
                result.add(root.val);
                if (root.right != null) {
                    root = root.right;
                } else {
                    if (stack.isEmpty()) {
                        break;
                    }
                    root = stack.pop();
                    root.left = null;
                }
            } else {
                stack.push(root);
                root = root.left;
            }
        } while (true);

        return result;
    }

}