package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/16
 * @desc
 */
public class MovingCount {

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(38,15,9));
    }

    public int movingCount(int m, int n, int k) {
        int[][] data = new int[m][n];
        return moving(0, 0 ,m, n, k, data);
    }

    public int moving(int i,int j,int m,int n,int k, int[][] data) {
        if (!j(i, j, k)) {
            return 0;
        }
        data[i][j] = 1;
        int result = 1;
        if (i - 1 >= 0 && data[i - 1][j] == 0) {
            result += moving(i - 1, j, m, n, k, data);
        }

        if (j - 1 >= 0 && data[i][j - 1] == 0) {
            result += moving(i, j - 1, m, n, k, data);
        }
        if (i + 1 < m && data[i + 1][j] == 0) {
            result += moving(i + 1, j, m, n, k, data);
        }
        if (j + 1 < n && data[i][j + 1] == 0) {
            result += moving(i, j + 1, m, n, k, data);
        }

        return result;
    }

    public boolean j(int i, int j,int k) {

        int t = 0, z = i;
        while (z != 0) {
            t += z % 10;
            z /= 10;
        }
        if (t > k) {
            return false;
        }
        z = j;
        while (z != 0) {
            t += z % 10;
            z /= 10;
        }
        return t <= k;
    }
    }
