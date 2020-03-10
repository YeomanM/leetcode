package com.leetcode;

import java.util.Arrays;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/8
 * @desc 322
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{83,186,408,419};
        System.out.println(new CoinChange().coinChange(coins, 6249));
    }

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        int min,t;
        Arrays.sort(coins);
        int[] result = new int[amount+1];
        result[0] = 0;
        for (int i = 1; i <= amount; i++) {
            if (i < coins[0]) {
                result[i] = -1;
                continue;
            }

            min = Integer.MAX_VALUE;
            for (int i1 = coins.length - 1; i1 >= 0; i1--) {
                if (coins[i1] <= i) {
                    t = result[i - coins[i1]];
                    if (t != -1 && t + 1 < min) {
                        min = t + 1;
                    }
                }
            }

            min = min == Integer.MAX_VALUE ? -1 : min;
            result[i] = min;
        }

        return result[amount];
    }

}
