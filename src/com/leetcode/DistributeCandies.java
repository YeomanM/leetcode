package com.leetcode;

import java.util.regex.Pattern;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/5
 * @desc 1103
 */
public class DistributeCandies {

    public int[] distributeCandies(int candies, int num_people) {
        int n = (int) Math.sqrt(candies << 1), temp;
        int total = (n * n + n) >> 1;
        if (total > candies) {
            n = n - 1;
            total = (n * n + n) >> 1;
        }
        temp = candies - total;
        int t = n / num_people, s = n % num_people;

        int[] result = new int[num_people];
        if (t == 0) {
            for (int i = 0;i < num_people; i++) {
                if (i == n) {
                    result[i] = temp;
                } else if (i < s) {
                    result[i] = i + 1;
                } else {
                    result[i] = 0;
                }
            }
        } else {
            for (int i = 0;i < num_people; i++) {
                if (i == s) {
                    result[i] = (i + 1) * t + ((t - 1) * t >> 1) * num_people + temp;
                } else if (i < s) {
                    result[i] = (i + 1) * (t + 1) + ((t + 1) * t >> 1) * num_people;
                } else {
                    result[i] = (i + 1) * t + ((t - 1) * t >> 1) * num_people;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        for (int i : new DistributeCandies().distributeCandies(90, 4)) {
            System.out.println(i);
        }
    }

}
