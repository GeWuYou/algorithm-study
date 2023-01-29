package com.gewuyou.algorithm.swordpointstooffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺子
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName StraightInPoker
 * @apiNote </br>
 * @since 2023/2/2 15:55
 */
public class StraightInPoker {
    public static boolean isStraight(int[] nums) {
        // 最大值
        int max = Integer.MIN_VALUE;
        // 最小值
        int min = Integer.MAX_VALUE;
        // 保证值不重复
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                // 保证数组值不重复
                if (numbers.contains(num)) {
                    return false;
                } else {
                    numbers.add(num);
                }
                // 寻找最小值
                if (num < min) {
                    min = num;
                }
                // 寻找最大值
                if (num > max) {
                    max = num;
                }
            }
        }
        // 判断最大点数与最小点数差值
        return max - min < 5;
    }
}
