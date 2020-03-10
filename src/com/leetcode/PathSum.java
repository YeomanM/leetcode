package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/1/22
 * @desc
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null) {
            pathSum(root, sum, list, lists);
        }
        return lists;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> list, List<List<Integer>> lists) {

        list.add(root.val);
        int c = sum - root.val;
        if (root.left == null && root.right == null && c == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            if (root.left != null) {
                pathSum(root.left, c, list, lists);
            }
            if (root.right != null) {
                pathSum(root.right, c, list, lists);
            }
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,null,5,1};
        TreeNode root = TreeUtil.createTree(nums);
        List<List<Integer>> lists = new PathSum().pathSum(root, 22);
        System.out.println(lists);
    }

}
