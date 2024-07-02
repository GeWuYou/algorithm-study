package com.gewuyou.algorithm.problem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 227. 基本计算器 II
 *
 * @author gewuyou
 * @since 2024-07-23 上午9:16:57
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char prev = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (prev) {
                    case '+':
                        stack.push(num);
                        break;

                    case '-':
                        stack.push(-num);
                        break;

                    case '*':
                        stack.push(stack.pop() * num);
                        break;

                    default:
                        stack.push(stack.pop() / num);
                        break;
                }
                prev = s.charAt(i);
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }


    public static void main(String[] args) {
        var solution = new BasicCalculatorII();
        var result = solution.calculate("1-1+1");
        System.out.println(result);
    }
}
