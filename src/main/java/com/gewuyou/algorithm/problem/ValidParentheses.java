package com.gewuyou.algorithm.problem;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ValidParentheses
 * @apiNote </br>
 * @since 2023/4/11 10:12
 */
public class ValidParentheses {
    public boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        // 1、创建栈对象，用来存储左括号
        Stack<Character> stack = new Stack<>();
        // 2、从左往右遍历字符串
        for (char c : str.toCharArray()) {
            // 3、判断当前字符是否为左括号，如果是，则把右括号放入到栈中
            if ('(' == c) {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            }
            // 4、继续判断当前字符是否是有括号，如果是，则从栈中弹出一个右括号，并判断弹出的结果是否为null,如果为null证明没有匹配的左括号，如果不为null，则证明有匹配的左括号
            else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        // 5、判断栈中还有没有剩余的左括号，如果有，则证明括号不匹配
        return stack.empty();
    }

}
