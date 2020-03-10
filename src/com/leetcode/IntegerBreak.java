package com.leetcode;

/**
 * @Description :
 * ---------------------------------
 * @Author : Yeoman
 * @Date : Create in 2019/8/15
 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(120));

        System.out.println(1000000008%1000000007);

    }

    public int integerBreak(int n) {

        int mid = 7;
        if (n < mid){
            int a = (n >> 1);
            return a * (n - a);
        }

        int time = 2,sub,cnt1,cnt2,last = -1,total = 0;
        while (total > last){
            last = total;
            sub = n / time;
            cnt2 = n - time * sub;
            cnt1 = (int) Math.pow(sub,time - cnt2);
            cnt2 = (int) Math.pow(sub + 1,cnt2);
            total = cnt1 * cnt2;
            time++;
        }
        return last;
    }

}
