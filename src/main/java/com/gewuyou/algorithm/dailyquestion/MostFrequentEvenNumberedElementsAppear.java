package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 出现最频繁的偶数元素
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MostFrequentEvenNumberedElementsAppear
 * @apiNote </br>
 * @since 2023/4/13 9:26
 */
public class MostFrequentEvenNumberedElementsAppear {
    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            // 判断是否为偶数
            if ((num & 1) == 0) {
                map.merge(num, 1, Integer::sum);
            }
        }
        int count = 0;
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (result == -1 || entry.getValue() > count || entry.getValue() == count && result > entry.getKey()) {
                result = entry.getKey();
                count = entry.getValue();
            }
        }
        return result;
    }
}
