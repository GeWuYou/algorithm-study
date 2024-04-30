package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 驼峰式匹配
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName CamelMatching
 * @apiNote </br>
 * @since 2023/4/14 9:40
 */
public class CamelMatching {
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        // 创建结果集合
        List<Boolean> result = new ArrayList<>();
        int index = 0;
        // 计算模式串中大写字母个数
        int patternCount = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) >= 'A' && pattern.charAt(i) <= 'Z') {
                patternCount++;
            }
        }
        // 遍历字符串数组
        for (String s : queries) {
            // 计算该字符串的大写字母个数
            int sCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    sCount++;
                }
            }
            if (sCount != patternCount) {
                result.add(false);
                continue;
            }
            for (int i = 0; i < s.length(); i++) {
                if(index==pattern.length()){
                    break;
                }
                if (index < pattern.length() && s.charAt(i) == pattern.charAt(index)) {
                    index++;
                }
            }
            if (index != pattern.length()) {
                result.add(false);
            } else {
                result.add(true);
            }
            index = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"ForceFeedBack"};
        String pattern = "FoBaT";
        System.out.println(camelMatch(strings, pattern));
    }
}
