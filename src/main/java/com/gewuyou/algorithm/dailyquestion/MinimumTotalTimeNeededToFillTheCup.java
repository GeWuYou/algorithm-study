package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 装满杯子需要的最短总时长
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MinimumTotalTimeNeededToFillTheCup
 * @apiNote </br>
 * @since 2023/2/11 13:08
 */
public class MinimumTotalTimeNeededToFillTheCup {
    public int fillCups(int[] amount) {
        // 排序数组
        Arrays.sort(amount);
        // 计算次数
        int count = 0;
        while (amount[0] > 0) {
            // 让第二大的与最少的相互接近
            if (amount[1] > amount[0]) {
                count++;
                amount[1]--;
                amount[2]--;
            } else {
                count++;
                amount[0]--;
                amount[2]--;
            }
            // 如果配置水的时候最大的需求被消耗光，返回剩下的最大的值与次数
            if (amount[2] == 0) {
                return count + Math.max(amount[0], amount[1]);
            }
        }
        // 当最少的已经配置完了，只可能全部已经配置完了或者最多的还没有配置完
        return count + amount[2];
    }

    public int fillCupsBak(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[1] + amount[0]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
}
