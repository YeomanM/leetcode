package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/4/10
 * @desc
 */
public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder r = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        boolean first = true;

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ' && (r.length() > 0)) {
                if (!first) {
                    builder.append(" ");
                }
                first = false;
                builder.append(r);
                r = new StringBuilder();
            } else if (chars[i] != ' ') {
                r.insert(0, chars[i]);
            }
        }

        if (r.length() > 0) {
            if (!first) {
                builder.append(" ");
            }
            builder.append(r);
        }

        return builder.toString();
    }

}
