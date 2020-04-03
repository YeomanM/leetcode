package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/17
 * @desc
 */
public class CountCharacters {

    public int countCharacters(String[] words, String chars) {

        int l = chars.length();
        if (l == 0) {
            return 0;
        }

        int result = 0,len = 0,index,i;
        boolean[] cs = new boolean[l];
        char c;

        for (String word : words) {
            len = word.length();
            for (i = 0; i < len; i++) {
                c = word.charAt(i);
                for (index = 0; index < l; index++) {
                    if (c == chars.charAt(index) && !cs[index]) {
                        cs[index] = true;
                        break;
                    }
                }

                if (index == l) {
                    break;
                }
            }

            if (len == i) {
                result += len;
            }

            for (int i1 = 0; i1 < l; i1++) {
                cs[i1] = false;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(new CountCharacters().countCharacters(words, chars));
    }

}
