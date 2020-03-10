package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/8
 * @desc 面试题32
 */
public class LevelOrder {

    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        List<Integer> list = new ArrayList<>();
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] results = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            results[i] = list.get(i);
        }
        return results;
    }

    public static void main(String[] args) {
        Integer[] m = {3,9,20,null,null,15,7};
        TreeNode node = TreeUtil.createTree(m);

        for (int i : new LevelOrder().levelOrder(node)) {
            System.out.println(i);
        }

    }

}
