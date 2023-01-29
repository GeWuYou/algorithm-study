package com.gewuyou.algorithm.problem;

import java.util.Stack;

/**
 * 有效的括号序列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ValidParenthesisSequence
 * @apiNote </br>
 * @since 2023/1/7 20:03
 */
public class ValidParenthesisSequence {
    /**
     * 左小括号
     */
    String leftParenthesis = "(";

    /**
     * 左中括号
     */
    String leftBracket = "[";
    /**
     * 左大括号
     */
    String leftCurlyBrace = "{";

    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // 创建一个辅助栈存储左括号
        Stack<String> stack = new Stack<>();
        // 将字符串分割为字符串数组
        String[] string = s.split("");
        // 遍历字符串数组
        for (String symbol : string) {
            // 判断当前字符串是否为左括号
            if (leftParenthesis.equals(symbol) || leftBracket.equals(symbol) || leftCurlyBrace.equals(symbol)) {
                // 将左括号加入栈中
                stack.push(symbol);
                // 跳过后续操作
                continue;
            }
            // 判断当前字符串是否与辅助栈顶元素匹配
            // 判断栈是否为空
            if (!stack.isEmpty()) {
                if (matching(stack.peek()).equals(symbol)) {
                    // 匹配则弹出
                    stack.pop();
                } else {
                    // 不匹配则，该序列无效
                    return false;
                }
            } else {
                // 为空说明栈空但还存有右括号，该序列无效
                return false;
            }
        }
        // 遍历完字符串后判断栈内是否还存有左括号
        return stack.isEmpty();
    }

    /**
     * 匹配对应的括号
     *
     * @param s 左括号
     * @return java.lang.String
     * @apiNote 传入左括号，返回对应的右括号
     * @since 2023/1/7 20:46
     */
    public String matching(String s) {
        if (leftParenthesis.equals(s)) {
            return ")";
        } else if (leftBracket.equals(s)) {
            return "]";
        }
        return "}";
    }
}
