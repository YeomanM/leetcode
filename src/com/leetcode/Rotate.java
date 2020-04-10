package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/4/7
 * @desc 面试题 01.07. 旋转矩阵
 *
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class Rotate {

    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        new Rotate().rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }

        int tmp, last = n + 1 >> 1;

        for (int i = 0;i < last; i++) {
            for (int j = i, l = n - i - 1;j < l; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 -j];
                matrix[n - 1 - i][n - 1 -j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }

}
