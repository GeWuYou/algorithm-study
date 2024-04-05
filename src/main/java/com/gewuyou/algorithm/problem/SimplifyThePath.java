package com.gewuyou.algorithm.problem;

import com.gewuyou.datastructures.linear.Stack;

/**
 * 简化路径
 *
 * @author gewuyou
 * @since 2024-04-19 下午3:32:08
 */
public class SimplifyThePath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (String s : paths) {
            if ("..".equals(s) && !stack.isEmpty()) {
                stack.pop();
            }
            if (!".".equals(s) && !"..".equals(s) && !s.isEmpty()) {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
}
