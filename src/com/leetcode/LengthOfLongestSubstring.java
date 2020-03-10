package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/8
 * @desc 面试48
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("aabaab!bb"));
    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] result = new int[128];
        int length = s.length(),temp = -1, v = 0,in,max = 0,k;

        for (int i = 0; i < length; i++) {
            in = s.charAt(i);
//
//            if (' ' == s.charAt(i)) {
//                in = 26;
//            }

            v = result[in];
            if (i == 0) {
                result[in] = i + 1;
                temp = 1;
                continue;
            }

            if (v >= temp) {
                max = Math.max(i + 1 - temp, max);
                k = i + 1 - v;
                max = Math.max(k, max);
                temp = v + 1;
            }
            result[in] = i + 1;
        }


        if (length + 1 - temp > max) {
            max = length + 1 - temp;
        }

        return max == 0 ? length : max;
    }

}
