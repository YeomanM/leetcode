package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/2/18
 * @desc
 */
public class GetNoZeroIntegers {

    public static void main(String[] args) {
        int res = 0;
        for (int i : new GetNoZeroIntegers().getNoZeroIntegers(69)) {
            System.out.println(i);
            res+=i;
        }
        System.out.println(res);
    }

    public int[] getNoZeroIntegers(int n) {
        int[] result = {0,0};

        int left = 0,index = 0;
        while (n != 0) {
            left = n % 10;
            n /= 10;
            if (left > 1) {
                result[0] += (int) (1 * Math.pow(10,index));
                result[1] += (int) ((left - 1) * Math.pow(10, index));
            } else if (n == 0) {
                if (left == 1) {
                    result[0] += (int) (1 * Math.pow(10,index));
                }
            } else {
                if (left == 1) {
                    result[0] += (int) (2 * Math.pow(10,index));
                    result[1] += (int) (9 * Math.pow(10, index));
                    n--;
                } else  {
                    result[0] += (int) (1 * Math.pow(10,index));
                    result[1] += (int) (9 * Math.pow(10, index));
                    n--;
                }
            }
            index++;
        }
        return result;
    }

}
