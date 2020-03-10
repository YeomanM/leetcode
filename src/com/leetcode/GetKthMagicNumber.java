package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * GetKthMagicNumber
 */
public class GetKthMagicNumber {

    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            System.out.println(new GetKthMagicNumber().getKthMagicNumber(i + 1));
//        }
        System.out.println(new GetKthMagicNumber().getKthMagicNumber(251));
    }

    public int getKthMagicNumber(int k) {
        if (k == 1) {
            return 1;
        } else if (k == 2) {
            return 3;
        } else if (k == 3) {
            return 5;
        } else if (k == 4){
            return 7;
        }

        int t1,t2,t3,last;

        int index = 0;
        List<Integer> list = new ArrayList<Integer>(){{
            add(1);
        }};

        int[] indexs = {0,0,0};

        while(index < k) {
            last = list.get(index);
            t1 = list.get(indexs[0]) * 3;
            t2 = list.get(indexs[1]) * 5;
            t3 = list.get(indexs[2]) * 7;

            if (t1 <= last) {
                indexs[0]++;
                t1 = list.get(indexs[0]) * 3;
            }

            if (t2 <= last) {
                indexs[1]++;
                t2 = list.get(indexs[1]) * 5;
            }

            if (t3 <= last) {
                indexs[2]++;
                t3 = list.get(indexs[2]) * 7;
            }

            index++;
            if (t1 > last && (t2 <= last && t3 <= last || t1 < t2 && t1 <= t3 || t1 <= t2 && t3 <= last || t1 <= t3 && t2 <= last)) {
                indexs[0]++;
                list.add(t1);
            } else if (t2 > last && (t1 <= last && t3 <= last || t2 <= t1 && t2 <= t3 || t2 <= t1 && t3 <= last || t2 <= t3 && t1 <= last)){
                indexs[1]++;
                list.add(t2);
            } else if (t3 > last && (t1 <= last && t2 <= last || t3 <= t2 && t3 <= t1 || t3 <= t2 && t1 <= last || t3 <= t1 && t2 <= last)){
                indexs[2]++;
                list.add(t3);
            } else {
                index--;
            }
        }


        return list.get(k - 1);
    }
}