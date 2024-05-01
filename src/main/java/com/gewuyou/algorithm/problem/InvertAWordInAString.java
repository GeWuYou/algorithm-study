package com.gewuyou.algorithm.problem;

/**
 * 151. 反转字符串中的单词
 *
 * @author gewuyou
 * @since 2024-05-12 下午3:48:22
 */
public class InvertAWordInAString {
    public String reverseWords(String s) {
        // 使用正则表达式去除多余空格并分割单词
        String[] words = s.trim().split("\\s+");
        StringBuilder reversedString = new StringBuilder();
        // 倒序遍历单词数组，将单词连接到结果字符串
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]);
            if (i > 0) {
                reversedString.append(" ");
            }
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {

        String s = "the        sky     is blue";
        for (String string : s.split(" ")) {
            if(!" ".equals(string)){
                System.out.println("len-"+string.trim()+"-len");
            }
        }
        InvertAWordInAString solution = new InvertAWordInAString();
        String result = solution.reverseWords(s);
        System.out.println(result);
    }
}
