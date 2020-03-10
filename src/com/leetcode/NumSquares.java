package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/2/3
 * @desc
 */
public class NumSquares {

    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(12));
    }

    public int numSquares(int n) {

        List<Integer> list = new ArrayList<>();

        int pow = 0;
        for (int i = 1;;i++) {
            pow = i * i;
            if (pow > n) {
                break;
            } else if (pow == n) {
                return 1;
            }
            list.add(pow);
        }

        pow = list.remove(list.size() - 1);
        int result = Math.min(get(list, n - pow) + 1, get(list, pow));
        return 0;
    }

    public int get(List<Integer> list, int n) {
        if (n == 1) {
            return 1;
        } else if (list.size() == 1) {
            return n;
        }
        int pow = list.remove(list.size() - 1);
        return Math.min(get(list, n - pow) + 1, get(list, pow));
    }

}
