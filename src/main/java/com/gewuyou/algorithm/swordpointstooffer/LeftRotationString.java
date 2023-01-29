package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 左旋转字符串
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName LeftRotationString
 * @apiNote </br>
 * @since 2023/1/20 12:42
 */
public class LeftRotationString {
    public String reverseLeftWords(String s, int n) {
        // 计算字符串长度
        int length = s.length();
        // 如果字符串长度等于1或者操作长度大于实际长度直接返回
        if (length == 1 || n > length) {
            return s;
        }
        // 将字符串左旋
        return s.substring(n, length) + s.substring(0, n);
    }
}
