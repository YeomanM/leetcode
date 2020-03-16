package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/16
 * @desc
 */
public class MovingCount {

    public int movingCount(int m, int n, int k) {

        if (m < n) {
            int t = m;
            m = n;
            n = t;
        }

        int h = n, x = m, s = 1;
        if (n > k + 1) {
            h = k;
            x = k;
        } else if (m > k + 1) {
            x = k;
            s = k + 1 - n;
        } else {

        }

        int r = (s + x) *

    }

}
