package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 缺失的第一个正整数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TheFirstPositiveIntegerMissing
 * @apiNote </br>
 * @since 2023/1/16 18:17
 */
public class TheFirstPositiveIntegerMissing {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minNumberDisappeared(int[] nums) {
        // 构建哈希表
        Map<Integer, Integer> map = new HashMap<>(nums.length / 2);
        // 遍历数组
        for (int num : nums) {
            if (num > 0) {
                map.put(num, num);
            }
        }
        // 设置索引
        int index = 1;
        while (index < map.size()) {
            // 如果哈希表中找不到该映射
            if (map.get(index) == null) {
                // 返回此处的索引
                return index;
            }
            index++;
        }
        // 如果哈希表中均有映射，说明缺失的第一个正整数是后一位
        return index + 1;
    }
}
