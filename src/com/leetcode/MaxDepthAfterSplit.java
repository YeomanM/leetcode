package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/4/1
 * @desc 1111. 有效括号的嵌套深度
 */
public class MaxDepthAfterSplit {

    public static void main(String[] args) {
        int[] r = new MaxDepthAfterSplit().maxDepthAfterSplit("((())())");
        for (int i : r) {
            System.out.println(i);
        }
    }

    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];

        if (seq.isEmpty()) {
            return result;
        }

        int count = 0;
        char left = '(';
        char[] chars = seq.toCharArray();
        result[0] = 0;
        for (int i = 1, len = chars.length;i < len; i++) {
            if (chars[i] == left) {
                count++;
                result[i] = count & 1;
            } else {
                result[i] = count & 1;
                count--;

            }
        }
        return result;
    }

}
