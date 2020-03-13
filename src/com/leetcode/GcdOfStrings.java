package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GcdOfStrings {

    public static void main(String[] args) {
        String str1 = "LEET", str2 = "CODE";
        System.out.println(new GcdOfStrings().gcdOfStrings(str1,str2));
    }

    public String gcdOfStrings(String str1, String str2) {
        int s = str1.length(), e = str2.length();

        if (str1.equals(str2)) {
            return str1;
        }

        if (s == e) {
            return "";
        }

        if (s > e) {
            return handle(str1, str2);
        }

        return handle(str2, str1);

    }

    private String handle(final String l,final String s) {
        int ls = l.length(), ss = s.length();

        int temp;
        while (ls % ss != 0) {
            temp = ls % ss;
            if (temp > ss) {
                ls = temp;
            } else {
                ls = ss;
                ss = temp;
            }
        }

        if (ss == 1) {
            return "";
        }


        String t = s.substring(0, ss);
        if (check(l, t, ss) && check(s, t, ss)){
            return t;
        }

        int index = (int) Math.sqrt(ss) + 1;
        Set<Integer> nums = new HashSet<>();
        for (int i = 2; i < index; i++) {
            if (ss % i == 0) {
                nums.add(i);
                nums.add(ss / i);
            }
        }

        Iterator<Integer> iterator = nums.stream().sorted((a, b) -> -a.compareTo(b)).iterator();
        while (iterator.hasNext()) {
            temp = iterator.next();
            t = s.substring(0, temp);
            if (check(l, t, temp) && check(s, t, temp)){
                return t;
            }
        }


        return "";
    }

    private boolean check(String p, String c, int l) {
        int index = 0, len = p.length();
        String temp;
        do {
            temp = p.substring(index * l, (index + 1) * l);
            if (!temp.equals(c)) {
                return false;
            }
            index++;
        } while (index * l < len);
        return true;
    }


}
