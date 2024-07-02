package com.gewuyou.algorithm.problem;

import java.util.Stack;

/**
 * 151. 反转字符串中的单词
 *
 * @author gewuyou
 * @since 2024-05-12 下午3:48:22
 */
public class InvertAWordInAString {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = getStringBuilder(s);
        return sb.toString();
        // // 使用正则表达式去除多余空格并分割单词
        // String[] words = s.trim().split("\\s+");
        // StringBuilder reversedString = new StringBuilder();
        // // 倒序遍历单词数组，将单词连接到结果字符串
        // for (int i = words.length - 1; i >= 0; i--) {
        //     reversedString.append(words[i]);
        //     if (i > 0) {
        //         reversedString.append(" ");
        //     }
        // }
        // return reversedString.toString();
    }

    private static StringBuilder getStringBuilder(String s) {
        var stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && !stack.peek().equals(" ")) {
                stack.push(" ");
            }
            if (c != ' ') {
                StringBuilder temp = new StringBuilder();
                // i++;
                // if (i > s.length()-1) {
                //     stack.push(temp.toString());
                //     break;
                // }
                while (s.charAt(i) != ' ') {
                    temp.append(s.charAt(i));
                    i++;
                    if (i > s.length() - 1) {
                        break;
                    }
                }
                stack.push(temp.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb;
    }

    public static void main(String[] args) {
        String s = "F R  I   E    N     D      S      ";
        for (String string : s.split(" ")) {
            if (!" ".equals(string)) {
                System.out.println("len-" + string.trim() + "-len");
            }
        }
        InvertAWordInAString solution = new InvertAWordInAString();
        String result = solution.reverseWords(s);
        System.out.println(result);
    }
}
