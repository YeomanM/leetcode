package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/4/9
 * @desc
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3).forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        return generateParenthesis((n << 1) - 1, 1, "(");
    }

    public List<String> generateParenthesis(int n, int left, String parent) {

        List<String> list = new ArrayList<>();
        if (n == 0) {
            list.add(parent);
        } else {
            if (left > 0) {
                list.addAll(generateParenthesis(n - 1, left - 1, parent + ")"));
            }

            if (left + 1 <= n) {
                list.addAll(generateParenthesis(n - 1, left + 1, parent + "("));
            }
        }

        return list;
    }

}
