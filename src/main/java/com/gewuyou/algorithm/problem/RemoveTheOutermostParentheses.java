package com.gewuyou.algorithm.problem;

/**
 * 1021. 删除最外层的括号
 *
 * @author gewuyou
 * @since 2024-05-14 下午1:01:24
 */
public class RemoveTheOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                sb.append(s, start + 1, i);
                start = i + 1;
            }
        }
        return sb.toString();
    }

}
