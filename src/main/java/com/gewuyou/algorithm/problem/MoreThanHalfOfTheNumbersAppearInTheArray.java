package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MoreThanHalfOfTheNumbersAppearInTheArray
 * @apiNote </br>
 * @since 2023/1/16 11:49
 */
public class MoreThanHalfOfTheNumbersAppearInTheArray {
    public int MoreThanHalfNum_Solution(int[] array) {
        // 创建一个哈希表
        Map<Integer, Integer> result = new HashMap<>(array.length / 2);
        // 遍历数组将遇到的元素加入哈希表中
        for (int i = 0; i < array.length; i++) {
            // 如果哈希表中有该数据，则将其值自增
            if (result.containsKey(array[i])) {
                // 判断当前数据出现次数是否超过数组一半长度
                if (result.get(array[i]) + 1 > array.length / 2) {
                    return array[i];
                }
                result.put(array[i], result.get(array[i]) + 1);
            }
            // 如果该哈希表中没有该数据则将其添加到哈希表中
            else {
                result.put(array[i], 1);
            }
        }
        return array[0];
    }
}
