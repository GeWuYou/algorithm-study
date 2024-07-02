package com.gewuyou.algorithm.problem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. 基本计算器
 *
 * @author gewuyou
 * @since 2024-07-31 上午9:39:33
 */
public class BasicCalculator {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += (int) (sign * num);
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        var calculator = new BasicCalculator();
        System.out.println(calculator.calculate("1 + 1"));
    }
}
