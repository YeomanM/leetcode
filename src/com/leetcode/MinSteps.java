package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/2/24
 * @desc
 */
public class MinSteps {

    public int minSteps(int n) {

        if (n == 1) {
            return 0;
        }

        int result = 0;

        int start = 2, end = n / 2;
        while (start <= n && start <= end && n > 1) {
            if (n % start == 0) {
                result += start;
                n /= start;
            } else {
                start ++;
            }
        }
        return result == 0 ? n : result;
    }

}
