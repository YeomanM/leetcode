package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description :
 * ---------------------------------
 * @Author : Yeoman
 * @Date : Create in 2019/8/15
 */
public class GetPermutation {

    public static void main(String[] args) {
        System.out.println(new GetPermutation().getPermutation(3,6));
    }

    public String getPermutation(int n, int k) {
        StringBuilder builder = new StringBuilder();
        if (k == 1){
            for (int i = 1;i <= n; i++){
                builder.append(i);
            }
            return builder.toString();
        }
        int[] times = this.getEachPermutationTime(n);
        if (times[n-2] * n == k){
            for (int i = n;i > 0; i--){
                builder.append(i);
            }
            return builder.toString();
        }
        List<Integer> nums = new LinkedList<>();
        for (int i = 0;i <= n; i++){
            nums.add(i);
        }
        int i = 0;
        n -= 2;
        while (n >=0){
            i = k / times[n];
            k = k % times[n];
            i = i + (k == 0 ? 0 : 1);
            i = i + (i == 0 ? 1 : 0);
            builder.append(nums.remove(i));
            if (k == 0){
                break;
            }
            n--;
        }
        for (i = nums.size() - 1;i > 0; i--){
            builder.append(nums.get(i));
        }
        return builder.toString();
    }

    private int[] getEachPermutationTime(int n){
        int time = 1;
        int[] times = new int[n - 1];
        for (int i = 1;i < n; i++){
            time *= i;
            times[i-1] = time;
        }
        if (n == 2){
            times[0] = 1;
        } else {
            times[0] = 2;
        }
        return times;
    }

}
