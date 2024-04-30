package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 受标签影响的最大值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaximumValueAffectedByTheLabel
 * @apiNote </br>
 * @since 2023/5/23 10:13
 */
public class MaximumValueAffectedByTheLabel {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int result = 0;
        int count = 0;
        Map<Integer, Integer> marks = new HashMap<>();
        Integer []index = new Integer[values.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index,(a,b) -> values[b]-values[a]);
        for (int i = 0; i < index.length; i++) {
            if (count >= numWanted) {
                break;
            }
            // 获取当前出现的频次
            int frequency = marks.getOrDefault(labels[index[i]], 0) + 1;
            if (frequency > useLimit) {
                continue;
            }
            count++;
            marks.put(labels[index[i]], frequency);
            result += values[index[i]];
        }
        return result;
    }
}
