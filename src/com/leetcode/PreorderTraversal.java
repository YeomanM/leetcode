package com.leetcode;

import java.util.*;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/1/22
 * @desc
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root != null){

            Stack<TreeNode> queue = new Stack<>();
            queue.push(root);

            while (!queue.isEmpty()) {
                root = queue.pop();
                result.add(root.val);
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
//        Integer[] nums = {1,null,2,null,null,3};
        Integer[] nums = {1,4,3,2};
        TreeNode root = TreeUtil.createTree(nums);
        new PreorderTraversal().preorderTraversal(root).forEach(System.out::println);
    }

}
