package com.gewuyou.algorithm.dailyquestion;

/**
 * 二进制字符串前缀一致的次数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/6/14 15:58
 */
public class NumTimesAllBlue {
    public int numTimesAllBlue(int[] flips) {
        int length = flips.length;
        int count = 0;
        int right = 0;
        for (int i = 0; i < length; i++) {
            // 记录每一轮遍历时的最大索引值
            right = Math.max(right, flips[i]);
            // 当遍历的i(从1开始)等于最大值时，说明此时符合条件
            if (right == i + 1) {
                count++;
            }
        }
        return count;
    }
}
