package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 构造连续值的最大数目
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ConstructTheMaximumNumberOfConsecutiveValues
 * @apiNote </br>
 * @since 2023/2/4 14:01
 */
public class ConstructTheMaximumNumberOfConsecutiveValues {
    public int getMaximumConsecutive(int[] coins) {
        // 一开始只能构造出 0
        int sum = 0;
        Arrays.sort(coins);
        for (int c : coins) {
            // coins 已排序，后面没有比 c 更小的数了
            if (c > sum + 1) {
                // 无法构造出 sum+1，继续循环没有意义
                break;
            }// 可以构造出区间 [0,sum+c] 中的所有整数
            sum += c;
        }// [0,sum] 中一共有 sum+1 个整数
        return sum + 1;
    }
}
