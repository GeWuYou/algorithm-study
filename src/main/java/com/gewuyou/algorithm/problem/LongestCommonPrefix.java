package com.gewuyou.algorithm.problem;

/**
 * 最长公共前缀
 *
 * @author gewuyou
 * @since 2024-04-05 下午1:52:26
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strings) {
        /*
         * 分析：
         *  由于题目要求最长公共前缀，所以，除非没有公共前缀，每个字符串应当包含最长公共前缀
         *  我们可以以第一个字符串作为基准前缀，遍历后面的每一个字符串，判断后面的字符串是否包含基准字符串
         *  如果不包含，表明基准前缀中含有非公共的字符，因为公共前缀一定是从左向右排序，因此我们从后方开始缩减基准前缀
         *  这样必定能够找到最长公共前缀
         */
        if (strings.length == 0) {
            return "";
        }
        String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
