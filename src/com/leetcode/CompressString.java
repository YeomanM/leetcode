package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/16
 * @desc 面试题 01.06. 字符串压缩
 */
public class CompressString {

    public static void main(String[] args) {
        System.out.println(new CompressString().compressString("aabcccccaaa"));
    }

    public String compressString(String S) {


        int len = S.length();

        if (len < 3) {
            return S;
        }

        char[] sc = S.toCharArray();


        StringBuilder builder = new StringBuilder();
        int count = 1;
        char last = sc[0];

        for (int i = 1; i < len; i++) {
            if (last == sc[i]) {
                count++;
            } else {
                builder.append(last).append(count);
                count = 1;
                last = sc[i];
            }
        }

        builder.append(last).append(count);

        String result = builder.toString();

        if (result.length() > len) {
            return  S;
        }
        return result;
    }

}
