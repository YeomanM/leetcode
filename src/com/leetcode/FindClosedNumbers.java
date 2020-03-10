package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/2/26
 * @desc 面试题0504
 */
public class FindClosedNumbers {

    public static void main(String[] args) {
        int[] result = new FindClosedNumbers().findClosedNumbers(571603719);
        System.out.println(result[0] + "," + result[1]);
    }

    public int[] findClosedNumbers(int num) {

        int temp = num;
        if (num == 1) {
            return new int[]{2,-1};
        } else if (((num + 1) & num) == 0) {
            num = num << 1;
            if (num < 0) {
                num = -1;
            } else {
                num = num - temp + (temp >> 1) + 1;
            }
            return new int[]{num, -1};
        } else if (((num - 1) & num) == 0) {
            int low = num >> 1;
            num = num << 1;
            if (num < 0) {
                num = -1;
            }
            return new int[]{num, low};
        }

        byte[] bytes = new byte[32];

        int i = 0;
        while (temp != 0) {
            bytes[i++] = (byte) (temp & 1);
            temp = temp >> 1;
        }

        int high = -1, low = -1,zore;
        for (int j = 0, k = 1;j < i - 1; j++, k++) {
            if (low == -1 && bytes[j] == 0 && bytes[k] == 1){
                low = j;
            } else if (high == -1 && bytes[j] == 1 && bytes[k] == 0) {
                high = j;
            }

            if (low != -1 && high != -1) {
                break;
            }
        }

        int[] result = new int[2];
        int hi = i,li = i;
        if (high == -1) {
            hi++;
            high = i - 1 ;
        }

        if (low == i - 2) {
            li --;
        }

        zore = high - low - 1;
        for (int k = hi - 1; k >= 0; k--) {
            temp = bytes[k];
            if (k == high + 1 || k < zore) {
                temp = 1;
            } else if (k == high || (k < high && k >= zore && zore >= 0)){
                temp = 0;
            }
            result[0] = (result[0] << 1) + temp;

        }

        for (int k = li - 1; k > low + 1; k--) {
            temp = bytes[k];
            result[1] = (result[1] << 1) + temp;
        }
        result[1] = (result[1] << 1);
        result[1] = (result[1] << 1) + 1;
        temp = 0;
        for (int k = 0; k < low; k++) {
            result[1] = (result[1] << 1);
            temp = (temp << 1) + bytes[k];
        }
        result[1] += temp;
        return result;
    }
}
