package com.leetcode;

import java.util.Arrays;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/8
 * @desc 面试题45
 */
public class MinNumber {

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(new MinNumber().minNumber(nums));
    }

    public String minNumber(int[] nums) {


        Integer[] ns = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ns[i] = nums[i];
        }

        Arrays.sort(ns, (x,y) ->{
            return (x + "" + y).compareTo(y + "" + x);
        });

        StringBuilder builder = new StringBuilder();
        for (Integer n : ns) {
            builder.append(n);
        }
        return builder.toString();
    }

}
