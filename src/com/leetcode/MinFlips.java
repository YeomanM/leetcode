package com.leetcode;

import java.util.Collections;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/2/18
 * @desc
 */
public class MinFlips {

    public static void main(String[] args) {
        System.out.println(new MinFlips().minFlips(2, 6, 5));
        System.out.println(new MinFlips().minFlips(4, 2, 7));
        System.out.println(new MinFlips().minFlips(1, 2, 3));
    }

    public int minFlips(int a, int b, int c) {
        int result = 0;

        int[][] sum = new int[2][30];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 30; j++) {
                sum[i][j] = 0;
            }
        }



        count(a, sum[0]);
        count(b, sum[0]);
        count(c, sum[1]);

        for (int i = 0;i < 30; i++) {
            if (sum[0][i] == 0 || sum[1][i] ==0) {
                result += Math.abs(sum[0][i] - sum[1][i]);
            }
        }

        return result;
    }

    private void count(int n, int[] count) {
        int i = 0;
        while (n != 0) {
            count[i] = (n & 1) + count[i] ;
            n = n >> 1;
            i++;
        }
    }

}
