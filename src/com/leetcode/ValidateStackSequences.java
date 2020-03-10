package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/8
 * @desc 946
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        int[] push = {2,1,0};
        int[] pop = {1,2,0};
        System.out.println(new ValidateStackSequences().validateStackSequences(push, pop));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int length = pushed.length, pui = 0,poi = 0,ri = -1;
        int[] result = new int[length];
        while (length > pui && length > poi) {
            if (pushed[pui] == popped[poi]) {
                pui++;
                poi++;
                continue;
            }
            while (ri >= 0 && poi < length && result[ri] == popped[poi]) {
                ri--;
                poi++;
            }
            result[++ri] = pushed[pui++];
        }
        while (ri >= 0 && poi < length && result[ri] == popped[poi]) {
            ri--;
            poi++;
        }

        return ri < 0;
    }

}
