package com.leetcode;

import java.util.Stack;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/2/24
 * @desc
 */
public class Calculate {

    public static void main(String[] args) {
//        System.out.println(new Calculate().calculate("3+2*2"));
//        System.out.println(new Calculate().calculate(" 3/2 "));
//        System.out.println(new Calculate().calculate(" 3+5 / 2 "));
//        System.out.println(new Calculate().calculate("2+3-4"));
//        System.out.println(new Calculate().calculate("6/3*4"));
        System.out.println(new Calculate().calculate("1*2-3/4+5*6-7*8+9/10"));
    }

    public int calculate(String s) {

        Stack<Integer> num = new Stack<>();
        Stack<String> op = new Stack<>();


        char[] cs = s.toCharArray();
        int temp = 0, left = 0, p, su;
        String o = "";
        boolean add = true;
        for (char c : cs) {
            switch (c) {
                case ' ' :
                    break;
                case '+' :
                case '-' :
                    while (!op.isEmpty()) {
                        su = temp;
                        p = num.pop();
                        temp = calculate(p, String.valueOf(op.pop()) , su);
                    }
                    o = String.valueOf(c);
                    op.push(o);
                    num.push(temp);
                    temp = 0;
                    break;
                case '*' :
                case '/' :

                    if (!op.isEmpty() && "/*".contains(op.peek())) {
                        su = temp;
                        p = num.pop();
                        temp = calculate(p, String.valueOf(op.pop()) , su);
                    }

                    o = String.valueOf(c);
                    op.push(o);
                    num.push(temp);
                    temp = 0;
                    break;
                default:
                    temp = temp * 10 + Integer.parseInt(String.valueOf(c));
                    add = true;
                    break;
            }
        }

        if (add) {
            num.push(temp);
        }
        while (!op.empty()) {
            o = op.pop();
            su = num.pop();
            p = num.pop();
            num.push(calculate(p, o, su));
        }

        return num.pop();
    }

    public int calculate(int p, String o, int s) {
        switch (o) {
            case "+" : return p + s;
            case "-" : return p - s;
            case "*" : return p * s;
            default: return p / s;
        }
    }

}
