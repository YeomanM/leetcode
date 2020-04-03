package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/4/3
 * @desc 8. 字符串转换整数 (atoi)
 */
public class MyAtoi {

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("-6147483648"));
    }

    public int myAtoi(String str) {

        int len = str.length(), result = 0, t, m = 214748364, y = 7;

        boolean f = false;
        if (len != 0) {
            int i = 0;
            char[] chars = str.toCharArray();

            while (i < len) {
                if (chars[i] != ' '){
                    break;
                }
                i++;
            }
            if (i == len) {
                return result;
            }

            if (chars[i] != '+' && chars[i] != '-' && (chars[i] < '0' || chars[i] > '9')) {
                return result;
            }

            if (chars[i] == '-') {
                f = true;
            } else if (chars[i] != '+'){
                result = chars[i] - '0';
            }

            for (i = i + 1;i < len; i++) {
                if (chars[i] < '0' || chars[i] > '9') {
                    break;
                }
                t = chars[i] - '0';

                if (result > m || result == m && t > y) {
                    if (f) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }

                result = result * 10 + t;
            }
        }

        if (f) {
            return  -result;
        }

        return result;
    }

}
