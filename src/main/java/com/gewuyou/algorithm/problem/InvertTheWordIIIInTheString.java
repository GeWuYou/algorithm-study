package com.gewuyou.algorithm.problem;

/**
 * 557. 反转字符串中的单词 III
 *
 * @author gewuyou
 * @since 2024-04-22 下午1:27:53
 */
public class InvertTheWordIIIInTheString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            words[i] = sb.reverse().toString();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if(i!=words.length-1){
                sb.append(words[i]).append(" ");
            }else{
                sb.append(words[i]);
            }
        }
        return sb.toString();
    }
}
