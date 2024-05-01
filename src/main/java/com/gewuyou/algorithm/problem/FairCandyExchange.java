package com.gewuyou.algorithm.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 888. 公平的糖果交换
 *
 * @author gewuyou
 * @since 2024-05-06 下午3:55:03
 */
public class FairCandyExchange {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Set<Integer> set = new HashSet<>();
        int sum1 = 0, sum2 = 0;
        //计算爱丽丝和鲍勃的糖果数量
        for (int size : aliceSizes) {
            sum1 += size;
        }
        for (int bobSize : bobSizes) {
            sum2 += bobSize;
            set.add(bobSize);
        }
        // 遍历爱丽丝的糖果数量
        for (int aliceSize : aliceSizes) {
            // 计算鲍勃需要的糖果数量
            double t = (sum2 + 2 * aliceSize - sum1) / 2.0;
            // 鲍勃需要的糖果数量必须是整数
            if ((int) t - t != 0) {
                continue;
            }
            // 鲍勃需要的糖果数量必须在鲍勃的糖果种类中
            if (set.contains((int) t)) {
                return new int[]{aliceSize, (int) t};
            }
        }
        return new int[]{-1, -1};
    }
}
