package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/2/24
 * @desc
 */
public class GetValidT9Words {

    public List<String> getValidT9Words(String num, String[] words) {

        Set<Integer> set = new HashSet<>();
        String str, c;
        int temp;

        for (int i = 0; i < num.toCharArray().length; i++) {
            str = getChar(num.charAt(i) - '0');

            if (i == 0) {
                for (int i1 = 0; i1 < words.length; i1++) {
                    if (str.contains(String.valueOf(words[i1].charAt(i)))) {
                        set.add(i1);
                    }
                }
            } else {
                Iterator<Integer> iterator = set.iterator();
                while (iterator.hasNext()) {
                    temp = iterator.next();
                    c = String.valueOf(words[temp].charAt(i));
                    if (!str.contains(c)) {
                        iterator.remove();
                    }
                }
            }

        }

        List<String> result = new ArrayList<>();
        set.forEach(e -> {
            result.add(words[e]);
        });

        return result;
    }

    private String getChar(int num) {
        num = num - 2;
        int start = 97 + num * 3, length = 3;

        if (num == 5){
            length = 4;
        } else if (num == 6) {
            start += 1;
        } else if (num == 7) {
            length = 4;
            start += 1;
        }
        return getCharFromStart(start, length);
    }

    private String getCharFromStart(int start, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < length; i++) {
            builder.append((char) (start + i));
        }
        return builder.toString();
    }

//    "9675973753"
//            ["alasvnpzur", "znwdgoiwso", "wduzrpnqrv", "ymrkxqdrlf", "epsqjclyqe", "zopjysdqke", "zhfxsdeimz", "eitgrsdnvt"]
    public static void main(String[] args) {
        String num = "9675973753";
        String[] words = {"alasvnpzur", "znwdgoiwso", "wduzrpnqrv", "ymrkxqdrlf", "epsqjclyqe", "zopjysdqke", "zhfxsdeimz", "eitgrsdnvt"};
        for (String validT9Word : new GetValidT9Words().getValidT9Words(num, words)) {
            System.out.println(validT9Word);
        }
    }
}
