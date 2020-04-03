package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/4/2
 * @desc 289. 生命游戏
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *[
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 */
public class GameOfLife {

    public static void main(String[] args) {

        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };

        new GameOfLife().gameOfLife(board);

        for (int[] ints : board) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;

        if (m == 0) {
            return;
        }

        int n = board[0].length, r;

        //d - a   ==> 2
        //a - d   ==> 3
        for (int i = 0;i < m; i++) {
            for (int j = 0;j < n; j++) {
                gameOfLive(i, j, board);
            }
        }

        for (int i = 0;i < m; i++) {
            for (int j = 0;j < n; j++) {
                 if (board[i][j] == 2) {
                     board[i][j] = 1;
                 } else if (board[i][j] == 3) {
                     board[i][j] = 0;
                 }
            }
        }

    }

    private void gameOfLive(int i, int j, int[][] board) {
        int n = board[0].length, m = board.length, alive = 0;
        if (i - 1 >= 0) {
            alive += (board[i - 1][j] & 1);
            if (j - 1 >= 0) {
                alive += (board[i - 1][j - 1] & 1);
            }

            if (j + 1 < n) {
                alive += (board[i - 1][j + 1] & 1);
            }
        }

        if (j - 1 >= 0) {
            alive += (board[i][j - 1] & 1);
        }

        if (j + 1 < n) {
            alive += (board[i][j + 1] & 1);
        }

        if (i + 1 < m) {
            alive += (board[i + 1][j] & 1);
            if (j - 1 >= 0) {
                alive += (board[i + 1][j - 1] & 1);
            }

            if (j + 1 < n) {
                alive += (board[i + 1][j + 1] & 1);
            }
        }

        boolean b = board[i][j] == 1;
        if (b) {
            if (alive < 2 || alive > 3) {
                board[i][j] = 3;
            }
        } else {
            if (alive == 3) {
                board[i][j] = 2;
            }
        }

    }

}
