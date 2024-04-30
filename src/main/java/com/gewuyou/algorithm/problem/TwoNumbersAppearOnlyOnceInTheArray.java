package com.gewuyou.algorithm.problem;

import java.util.*;

/**
 * 数组中只出现一次的两个数字
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TwoNumbersAppearOnlyOnceInTheArray
 * @apiNote </br>
 * @since 2023/1/16 12:46
 */
public class TwoNumbersAppearOnlyOnceInTheArray {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce(int[] array) {
        // 创建一个哈希表
        Map<Integer, Integer> map = new HashMap<>(array.length);
        // 遍历数组
        for (int element : array) {
            // 如果哈希表中存在该键则将其值自增
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            }
            // 如果该哈希表中不存在该键则将其加入哈希表中
            else {
                map.put(element, 1);
            }
        }
        // 创建数组接收数据
        List<Integer> temp = new ArrayList<>();
        // 遍历集合中的值，返回值为1的键
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) {
                temp.add(integer);
            }
        }
        Collections.sort(temp);
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}
