package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 字母与数字
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName LettersAndNumbers
 * @apiNote </br>
 * @since 2023/3/11 14:15
 */
public class LettersAndNumbers {
    public String[] findLongestSubarray(String[] array) {
        // 如果是数字记为-1分 如果是字母记为1分 求当和为0时的最大数组长度
        // 创建一个哈希表记录前缀和出现的索引位置
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        // 元素和为0的最长子数组长度
        int maxLength = 0;
        // 开始下标
        int index = -1;
        // 前缀和
        int sum = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                sum++;
            } else {
                sum--;
            }
            // 判断此时前缀和是否再次到达0
            if (map.containsKey(sum)) {
                int firstIndex = map.get(sum);
                // 计算长度
                int temp = i - firstIndex;
                if (maxLength < temp) {
                    maxLength = temp;
                    // 更新开始下标
                    index = firstIndex + 1;
                }
            }else {
                // 记录此时的前缀和
                map.put(sum, i);
            }
        }
        String[] result = new String[maxLength];
        // 如果最大长度为0返回空数组
        if (maxLength == 0) {
            return result;
        }
        // 如果最大长度大于0则说明原来数组中存在字母与数字个数相同的子数组
        System.arraycopy(array, index, result, 0, maxLength);
        return result;
    }
}
