package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/11
 * @desc 面试题44. 数字序列中某一位的数字
 */
public class FindNthDigit {

    public static void main(String[] args) {
        System.out.println(new FindNthDigit().findNthDigit(1000));
    }

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }

        int z = 99;
        int start = 90,index = 2,sum = 9,last = 9;
        while (true) {
            sum += index * start;
            if (sum < 0 || sum >= n) {
                break;
            }
            last = sum;
            start *= 10;
            z += start;
            index++;
        }

        if (sum == n) {
            return 9;
        }

        n = n - last;
        int k = n / index;
        int t = n % index;

        k = k + z + (t == 0 ? 0 : 1);
        if (t == 0) {
            return k % 10;
        }
        for (int o = index; o > t; o--) {
            k = k / 10;
        }
        for (int o = 0; o < t; o++) {
            k = k % 10;
        }
        return k;
    }

}
