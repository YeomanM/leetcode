package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/24
 * @desc 70. 爬楼梯
 */
public class ClimbStairs {

    public static void main(String[] args) {

        String s = "data={\"param\":\"{\\\"queryId\\\":\\\"1|49854673|undefined\\\",\\\"cubeId\\\":\\\"tblive_rpt_ind_trend\\\",\\\"queryDetail\\\":false,\\\"startTime\\\":\\\"2020-03-23 08:30:22\\\",\\\"endTime\\\":\\\"2020-03-24 00:01:33\\\",\\\"timeType\\\":2,\\\"sign\\\":null,\\\"limit\\\":2000,\\\"row\\\":\\\"[{\\\\\\\"name\\\\\\\":\\\\\\\"时间精确到分钟\\\\\\\",\\\\\\\"isMeasure\\\\\\\":false}]\\\",\\\"measure\\\":\\\"[{\\\\\\\"name\\\\\\\":\\\\\\\"观看次数\\\\\\\",\\\\\\\"isMeasure\\\\\\\":true}]\\\",\\\"column\\\":\\\"[]\\\",\\\"orders\\\":\\\"[]\\\",\\\"filter\\\":\\\"[{\\\\\\\"name\\\\\\\":\\\\\\\"开播日期分区字段yyyymmdd\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"dimension\\\\\\\",\\\\\\\"isMeasure\\\\\\\":false,\\\\\\\"values\\\\\\\":[\\\\\\\"20200323\\\\\\\"],\\\\\\\"oper\\\\\\\":\\\\\\\"=\\\\\\\"},{\\\\\\\"name\\\\\\\":\\\\\\\"直播间id\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"dimension\\\\\\\",\\\\\\\"isMeasure\\\\\\\":false,\\\\\\\"values\\\\\\\":[\\\\\\\"256821689150\\\\\\\"],\\\\\\\"oper\\\\\\\":\\\\\\\"=\\\\\\\"},{\\\\\\\"name\\\\\\\":\\\\\\\"主播id\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"dimension\\\\\\\",\\\\\\\"isMeasure\\\\\\\":false,\\\\\\\"values\\\\\\\":[916243692],\\\\\\\"oper\\\\\\\":\\\\\\\"=\\\\\\\"}]\\\",\\\"extra\\\":null}\"}";
        System.out.println(s.contains("\"观看次数\\\\\\\""));
        System.out.println(new ClimbStairs().climbStairs(3));
    }

    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }
        int a = 1, b = 2, res;
        for (int i = 2;i < n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return b;
    }

}
