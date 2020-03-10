package com.leetcode;

import java.util.*;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/6
 * @desc
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        for (int[] ints : new FindContinuousSequence().findContinuousSequence(100)) {
            for (int a : ints) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public int[][] findContinuousSequence(int target) {

        if(target == 1 || target == 2) {
            return new int[][]{};
        }

        int temp = Integer.MAX_VALUE;
        int length = 0;
        List<Integer> keys = new ArrayList<>(), values = new ArrayList<>();
        for (int i = 2, t = target >> 1;i < t;i++) {
            temp = target / i;
            if (target % i == 0) {
                if ((i & 1) == 1 && i < (temp << 1)) {
                    keys.add(i);
                    values.add(temp);
                    length += 1;
                    if ((temp & 1) == 1 && temp > (i << 1)) {
                        length++;
                    }
                } else if ((i & 1) == 0 && (temp & 1) == 1 && (temp >> 1) >= i) {
                    keys.add(i);
                    values.add(temp);
                    length ++;
                }
            }
        }

        int len = length + (target & 1);
        int[][] result = new int[len][];

        int[] child;
        int s,t, sv, tv;


        int index = 0;
        for (int i = keys.size() - 1; i >= 0; i--) {
            t = keys.get(i);
            tv = values.get(i);
            if ((t & 1) == 0) {
                child =c(t, tv);
            } else {

                if ((tv & 1) == 1 && tv > (t << 1)) {
                    result[index++] = c(t, tv);
                }

                child = new int[t];
                t = t >> 1;
                child[t++] = tv++;
                sv = tv - 2;

                for (s = t - 2; s >= 0; s--, t++) {
                    child[s] = sv--;
                    child[t] = tv++;
                }
            }
            result[index++] = child;
        }

        if ((target & 1) == 1) {
            temp = target >> 1;
            result[len - 1] = new int[]{temp, temp + 1};
        }

        Arrays.sort(result, Comparator.comparingInt(a -> a[0]));

        return result;
    }

    private int[] c(int t, int tv) {
        int[] child = new int[t << 1];
        int sv = tv >> 1;
        tv = sv + 1;
        for (int s = t - 1; s >= 0; s--, t++) {
            child[s] = sv--;
            child[t] = tv++;
        }
        return child;
    }

}
