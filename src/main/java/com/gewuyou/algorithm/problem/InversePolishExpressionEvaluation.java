package com.gewuyou.algorithm.problem;


import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 *
 * @author gewuyou
 * @since 2024-05-12 下午3:07:22
 */
public class InversePolishExpressionEvaluation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        if(tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }
        // 数字栈
        Stack<Integer> stack = new Stack<>();
        // 符号栈
        Stack<String> symbolStack = new Stack<>();
        for (String token : tokens) {
            if (!symbolStack.isEmpty() && stack.size() >= 2) {
                extracted(stack, symbolStack);
            }
            // 符号
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                symbolStack.push(token);
            } else {

                // 数字
                stack.push(Integer.parseInt(token));
            }
        }
        extracted(stack, symbolStack);
        return stack.pop();
    }

    private static void extracted(Stack<Integer> stack, Stack<String> symbolStack) {
        int num1 = stack.pop();
        int num2 = stack.pop();
        // 弹出符号
        String symbol = symbolStack.pop();
        if ("+".equals(symbol)) {
            stack.push(num2 + num1);
        } else if ("-".equals(symbol)) {
            stack.push(num2 - num1);
        } else if ("*".equals(symbol)) {
            stack.push(num2 * num1);
        } else if ("/".equals(symbol)) {
            stack.push(num2 / num1);
        }
    }

    public static void main(String[] args) {

        String[] tokens = {"4", "13", "5", "/", "+"};
        InversePolishExpressionEvaluation solution = new InversePolishExpressionEvaluation();
        int result = solution.evalRPN(tokens);
        System.out.println(result); // 9
    }
}
