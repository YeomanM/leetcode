package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/9
 * @desc
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {4,7,2,1};
        System.out.println(new MaxProfit().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        int max = prices[0],min = prices[0], result = 0,temp;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                temp = max - min;
                result = Math.max(result, temp);
                min = max = prices[i];
            } else if (prices[i] > max) {
                max = prices[i];
            }
        }
        temp = max - min;
        return Math.max(result, temp);
    }

}
