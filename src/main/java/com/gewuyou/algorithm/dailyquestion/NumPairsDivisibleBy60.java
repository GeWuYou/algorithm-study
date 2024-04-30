package com.gewuyou.algorithm.dailyquestion;

/**
 * 总持续时间可被 60 整除的歌曲
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NumPairsDivisibleBy60
 * @apiNote </br>
 * @since 2023/5/7 11:53
 */
public class NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        // 创建数组记录余数出现的次数
        int[] remainder = new int[60];
        // 遍历time计算余数，统计出现次数
        for (int i : time) {
            remainder[i % 60]++;
        }
        long result = 0;
        // 计算余数在[1,29]处的数字满足要求的对数
        for (int i = 1; i < 30; i++) {
            result += (long) remainder[i] * remainder[60 - i];
        }
        // 余数为0的歌曲，需要与余数为0的歌曲组成对，但不能和自己组对
        // 余数为30的歌曲同理
        result += ((long) remainder[0] * (remainder[0] - 1) / 2 + (long) remainder[30] * (remainder[30] - 1) / 2);
        return (int) result;
    }
}
