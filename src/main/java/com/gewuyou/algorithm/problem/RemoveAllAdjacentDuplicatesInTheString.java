package com.gewuyou.algorithm.problem;

import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 *
 * @author gewuyou
 * @since 2024-05-15 下午12:12:15
 */
public class RemoveAllAdjacentDuplicatesInTheString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() || s.charAt(i)!= stack.peek()){
                stack.push(s.charAt(i));
            }else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
