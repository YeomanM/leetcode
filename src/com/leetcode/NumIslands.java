package com.leetcode;

import java.util.Stack;

/**
 * NumIslands
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        
        int x = grid.length;
        int y = grid[0].length;
        int k = -1;
        int result = 0;
        for (int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = '2';
                    j = build(grid, i, j);
                    result ++;
                }
            }
        }

        return result;
    }

    public int build(char[][] grid, int i, int j) {
        int x = grid.length;
        int y = grid[0].length;
        Point p = new Point(i, j);
        Stack<Point> stack = new Stack<>();
        stack.push(p);
        int r = j;

        while(!stack.isEmpty()) {
            p = stack.peek();
            if (p.handle == 3) {
                p = stack.pop();
                if (p.y + 1 < y) {
                    if (grid[p.x][p.y + 1] == '1') {
                        grid[p.x][p.y + 1] = '2';
                        p = new Point(p.x, p.y + 1);
                        stack.push(p);
                        if(p.x == i && p.y + 1 > j) {
                            r = p.y + 1;
                        } 
                    }
                }
            } else if (p.handle == 2){
                p.handle ++;
                if (p.x + 1 < x) {
                    if (grid[p.x + 1][p.y] == '1') {
                        grid[p.x + 1][p.y] = '2';
                        p = new Point(p.x + 1, p.y);
                        stack.push(p);
                    }
                }
            } else if (p.handle == 1){
                p.handle ++;
                if (p.x > 0) {
                    if (grid[p.x - 1][p.y] == '1') {
                        grid[p.x - 1][p.y] = '2';
                        p = new Point(p.x - 1, p.y);
                        stack.push(p);
                    }
                }
            } else if (p.handle == 0){
                p.handle ++;
                if (p.y > 0) {
                    if (grid[p.x][p.y - 1] == '1') {
                        grid[p.x][p.y - 1] = '2';
                        p = new Point(p.x, p.y - 1);
                        stack.push(p);
                    }
                }
            }
        }
        return r;
    }

    /**
     * InnerNumIslands
     */
    class Point {

        Point(int x,int y){
            this.x = x;
            this.y = y;
            this.handle = 0;
        }

        int x;
        int y;
        int handle;
        
    }

    public static void main(String[] args) {
//        char[][] grid = {
//            {'1','1','0','1','1'},
//            {'1','1','0','0','0'},
//            {'0','0','1','0','0'},
//            {'1','0','0','1','1'}
//        };

//        char[][] grid = {
//                {'1','1','1'},
//                {'0','1','0'},
//                {'1','1','1'}
//        };

        char[][] grid = {
                {'1','0','0','1','1','1','0','1','1','0','0','0','0','0','0','0','0','0','0','0'},
                {'1','0','0','1','1','0','0','1','0','0','0','1','0','1','0','1','0','0','1','0'},
                {'0','0','0','1','1','1','1','0','1','0','1','1','0','0','0','0','1','0','1','0'},
                {'0','0','0','1','1','0','0','1','0','0','0','1','1','1','0','0','1','0','0','1'},
                {'0','0','0','0','0','0','0','1','1','1','0','0','0','0','0','0','0','0','0','0'},
                {'1','0','0','0','0','1','0','1','0','1','1','0','0','0','0','0','0','1','0','1'},
                {'0','0','0','1','0','0','0','1','0','1','0','1','0','1','0','1','0','1','0','1'},
                {'0','0','0','1','0','1','0','0','1','1','0','1','0','1','1','0','1','1','1','0'},
                {'0','0','0','0','1','0','0','1','1','0','0','0','0','1','0','0','0','1','0','1'},
                {'0','0','1','0','0','1','0','0','0','0','0','1','0','0','1','0','0','0','1','0'},
                {'1','0','0','1','0','0','0','0','0','0','0','1','0','0','1','0','1','0','1','0'},
                {'0','1','0','0','0','1','0','1','0','1','1','0','1','1','1','0','1','1','0','0'},
                {'1','1','0','1','0','0','0','0','1','0','0','0','0','0','0','1','0','0','0','1'},
                {'0','1','0','0','1','1','1','0','0','0','1','1','1','1','1','0','1','0','0','0'},
                {'0','0','1','1','1','0','0','0','1','1','0','0','0','1','0','1','0','0','0','0'},
                {'1','0','0','1','0','1','0','0','0','0','1','0','0','0','1','0','1','0','1','1'},
                {'1','0','1','0','0','0','0','0','0','1','0','0','0','1','0','1','0','0','0','0'},
                {'0','1','1','0','0','0','1','1','1','0','1','0','1','0','1','1','1','1','0','0'},
                {'0','1','0','0','0','0','1','1','0','0','1','0','1','0','0','1','0','0','1','1'},
                {'0','0','0','0','0','0','1','1','1','1','0','1','0','0','0','1','1','0','0','0'}
        };

        System.out.println(new NumIslands().numIslands(grid));

        for (char[] chars : grid) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }

    }
}