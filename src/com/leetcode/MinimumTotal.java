package com.leetcode;

import java.util.List;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/10
 * @desc 120. 三角形最小路径和
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] stack = new int[len];
        int last = triangle.get(len - 1).size() - 1;
        int it = 0,jt = 0, sum = stack[0],min = 0, temp = 0;

        while (it < len) {
            stack[it] = 0;
            min += triangle.get(it).get(0);
            it++;
        }
        sum = min;
        it--;
        while (stack[it] != last) {

            if (it == len - 1) {
                if (stack[it - 1] != stack[it] - 1) {
                    sum -= triangle.get(it).get(stack[it]);
                    sum += triangle.get(it).get(stack[it] + 1);
                    it--;
                    if (min > sum) {
                        min = sum;
                    }
                }
            }

            while (it >= 0 && stack[it - 1] == stack[it] - 1) {
                sum -= triangle.get(it).get(stack[it]);
                temp = stack[it];
                it--;
            }

            if (it < 0) {
                break;
            }

            boolean r = stack[it - 1] == stack[it] - 1,f = true;
            while (it < len) {
                if (r && f) {
                    if (it == 0) {
                        break;
                    }
                    sum -= triangle.get(it).get(stack[it]);
                    stack[it] = stack[it] + 1;
                    sum += triangle.get(it).get(stack[it]);
                    f = false;
                    continue;
                } else if (!r && f) {

                }

            }

        }

    }

}
