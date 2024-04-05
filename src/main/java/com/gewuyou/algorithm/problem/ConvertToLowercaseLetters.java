package com.gewuyou.algorithm.problem;

/**
 * 709. 转换成小写字母
 *
 * @author gewuyou
 * @since 2024-04-29 下午3:18:39
 */
public class ConvertToLowercaseLetters {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }
}
