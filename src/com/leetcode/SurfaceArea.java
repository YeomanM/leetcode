package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/25
 * @desc 892. 三维形体的表面积
 */
public class SurfaceArea {

    public static void main(String[] args) {
        int[][] grid = {{2,2,2},{2,1,2},{2,2,2}};
        System.out.println(new SurfaceArea().surfaceArea(grid));
    }

    public int surfaceArea(int[][] grid) {

        int il = grid.length;
        int jl = grid[0].length;

        int result = 0, temp, max;
        for (int i = 0; i < il; i++) {
            for (int j = 0; j < jl; j++) {
                if (grid[i][j] > 0) {
                    temp = 6 * grid[i][j] - 2 * (grid[i][j] - 1);
                } else {
                    temp = 0;
                }
                if (i - 1 >= 0) {
                    max = Math.min(grid[i][j], grid[i - 1][j]);
                    temp -= max * 2;
                }

                if (j - 1 >= 0) {
                    max = Math.min(grid[i][j], grid[i][j - 1]);
                    temp -= max * 2;
                }

                result += temp;
            }
        }
        return result;
    }

}
