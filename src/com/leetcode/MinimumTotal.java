package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/10
 * @desc 120. 三角形最小路径和
 */
public class MinimumTotal {

    public static void main(String[] args) {
        int[][] t = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        List<List<Integer>>triangle = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            List<Integer> temp = new ArrayList<>();
            triangle.add(temp);
            for (int j = 0;j < t[i].length; j++) {
                temp.add(t[i][j]);
            }
        }
        System.out.println(new MinimumTotal().minimumTotal(triangle));
    }

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
                    stack[it] = stack[it] + 1;
                    it--;
                    if (min > sum) {
                        min = sum;
                    }
                } else {

                }
            }

            while (it >= 0 && stack[it - 1] == stack[it] - 1) {
                sum -= triangle.get(it).get(stack[it]);
                it--;
            }

            if (it < 0) {
                break;
            }

            int k = stack[it],b = stack[it + 1] - 1;
            boolean r =  k == b,f = true;
            while (it < len) {

                if (it == len - 1) {
                    sum += triangle.get(it).get(stack[it]);
                    if (min > sum) {
                        min = sum;
                    }
                    break;
                }

                if (r && f) {
                    if (it == 0) {
                        break;
                    }
                    sum -= triangle.get(it).get(stack[it]);
                    stack[it] = stack[it] + 1;
                    sum += triangle.get(it).get(stack[it]);
                    f = false;
                } else if (!r && f) {
                    stack[it+1] = stack[it] + 1;
                    sum += triangle.get(it).get(stack[it]);
                    it++;
                } else {
                    stack[it+1] = stack[it];
                    sum += triangle.get(it).get(stack[it]);
                    it++;
                }
            }
        }
        return min;
    }

}
