package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TheSumOfTheTwoNumbers
 * @apiNote </br>
 * @since 2023/1/15 19:52
 */
public class TheSumOfTheTwoNumbers {
    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = 0;
        // 构建一个哈希表
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            // 判断目标值是否出现
            if (map.get(target - numbers[i]) != null) {
                if (i > map.get(target - numbers[i])) {
                    start = map.get(target - numbers[i]);
                    end = i;
                } else {
                    end = map.get(target - numbers[i]);
                    start = i;
                }
            }
            // 将已经遍历过的元素加入哈希表中
            map.put(numbers[i], i);
        }
        int[] result = new int[2];
        result[0] = start + 1;
        result[1] = end + 1;
        return result;
    }
}
