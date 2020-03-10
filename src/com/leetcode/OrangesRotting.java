//package com.leetcode;
//
///**
// * @author 冯宇明
// * @version 1.0
// * @date 2020/3/4
// * @desc 994
// */
//public class OrangesRotting {
//
//    public int orangesRotting(int[][] grid) {
//
//        int times = 0, bad = 3, t;
//        boolean one = false;
//        if (grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int x = grid.length, y = grid[0].length;
//        while (true) {
//            one = false;
//            for (int i = 0;i < x; i++) {
//                for (int j = 0; j < y; j++) {
//                    if (grid[i][j] > 1 && grid[i][j] < bad) {
//                        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
//                            grid[i - 1][j] = bad;
//                            one = true;
//                        }
//                        if (i + 1 < x && grid[i + 1][j] == 1){
//                            grid[i + 1][j] = bad;
//                            one = true;
//                        }
//                        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
//                            grid[i][j - 1] = bad;
//                            one = true;
//                        }
//                        if (j + 1 < y && grid[i][j + 1] == 1) {
//                            grid[i][j + 1] = bad;
//                            one = true;
//                        }
//
//                    }
//                }
//            }
//
//            if (one) {
//                bre
//            }
//        }
//
//
//    }
//
//}
