package com.leetcode;


/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/2/24
 * @desc 836. 矩形重叠
 */
public class IsRectangleOverlap {

    public static void main(String[] args) {
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {2,2,3,3};
        System.out.println(new IsRectangleOverlap().isRectangleOverlap(rec1, rec2));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        if (rec1[2] <= rec2[0] || rec1[0] >= rec2[2]) {
            return false;
        }

        if (rec1[3] <= rec2[1] || rec1[1] >= rec2[3]) {
            return false;
        }

        return true;

    }

}
