package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/11
 * @desc 1013. 将数组分成和相等的三个部分
 */
public class CanThreePartsEqualSum {

    public static void main(String[] args) {
        int[] a = {0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(new CanThreePartsEqualSum().canThreePartsEqualSum(a));
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0,length = A.length;

        for (int i = 0; i < length; i++) {
            sum += A[i];
        }

        if (sum % 3 != 0) {
            return false;
        }

        int c = sum / 3,index = 0;

        sum = 0;
        for (int i = 0; i < length; i++) {
            sum += A[i];
            if (sum == c && index != 3) {
                index++;
                if (index != 3) {
                    sum = 0;
                }
            }
        }

        return index == 3 && sum == c;
    }

}
