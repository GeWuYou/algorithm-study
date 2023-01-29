package com.gewuyou.algorithm.problem;


import java.util.HashMap;
import java.util.Stack;

/**
 * 表达式求值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ExpressionEvaluation
 * @apiNote </br> 支持加减×
 * @since 2023/1/15 13:06
 */
public class ExpressionEvaluation {
    /**
     * 加号
     */
    char plus = '+';
    /**
     * 减号
     */
    char minusSign = '-';
    /**
     * 乘号
     */
    char multiplicationSign = '*';
    /**
     * 左括号
     */
    char leftParenthesis = '(';
    /**
     * 右括号
     */
    char rightParenthesis = ')';

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     *
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve(String s) {
        // write code here
        //定义优先级，用map
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(plus, 1);
        map.put(minusSign, 1);
        map.put(multiplicationSign, 2);
        /**
         * 数字栈
         */
        Stack<Integer> numStack = new Stack<>();
        /**
         * 符号栈
         */
        Stack<Character> cStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果当前字符为数字
            if (c >= '0' && c <= '9') {
                int num = 0;
                //用while把num算好
                int j = i;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    num = num * 10 + (s.charAt(j) - '0');
                    j++;
                }
                //i置为数字的最后一位
                i = j - 1;
                // 将组合好的数字加入数组
                numStack.push(num);
            }
            // 如果当前字符为左括号
            else if (c == leftParenthesis) {
                cStack.push(c);
            }
            // 如果当前字符为右括号
            else if (c == rightParenthesis) {
                // 弹出栈中元素进行运算，直到栈顶元素为左括号
                while (cStack.peek() != leftParenthesis) {
                    compute(numStack, cStack);
                }
                //弹出左括号
                cStack.pop();
            } else {
                //如果当前字符为符号
                //如果在'('和')'里有多个运算符，在栈里的优先级高的话，应该先算栈里的符号
                while (!cStack.isEmpty() && cStack.peek() != leftParenthesis &&
                        map.get(cStack.peek()) >= map.get(c)) {
                    compute(numStack, cStack);
                }
                // 将符号加入栈中
                cStack.push(c);
            }
        }
        while (!cStack.isEmpty()) {
            compute(numStack, cStack);
        }
        return numStack.peek();
    }

    public void compute(Stack<Integer> numStack, Stack<Character> cStack) {
        int b = numStack.pop();
        int a = numStack.pop();
        char c = cStack.pop();
        if (c == plus) {
            numStack.push(a + b);
        } else if (c == minusSign) {
            numStack.push(a - b);
        } else if (c == multiplicationSign) {
            numStack.push(a * b);
        }
    }
}
