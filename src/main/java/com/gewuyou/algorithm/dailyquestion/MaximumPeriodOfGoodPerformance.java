package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 表现良好的最长时间段
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaximumPeriodOfGoodPerformance
 * @apiNote </br>
 * @since 2023/2/14 10:01
 */
public class MaximumPeriodOfGoodPerformance {
    public int longestWPI(int[] hours) {
        // 计算时间数组长度
        int length = hours.length;
        // 创建哈希表记录每一个前缀和第一次出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和
        int s = 0;
        // 结果
        int result = 0;
        for (int i = 0; i < length; i++) {
            // 当时间超过8记为分数+1反之-1
            s += hours[i] > 8 ? 1 : -1;
            // 如果前缀和大于0说明该段长度符合表现良好的时间段要求更新结果
            if (s > 0) {
                // i+1是因为索引从0开始
                result = Math.max(result, i + 1);
            }
            // 如果小于0，我们需要在前面试图寻找一个下标为j，满足s[j] = s[i] - 1。如果有，则表示取区间[j+1,i]是我们要找的已i结尾的最长区间
            else {
                if (map.containsKey(s - 1)) {
                    result = Math.max(result, i - map.get(s - 1));
                }
            }
            // 如果哈希表中不存在当前和对应出现的位置则加入
            map.putIfAbsent(s, i);
        }
        return result;
    }
}
