package com.gewuyou.algorithm.swordpointstooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName LongestSubstringWithoutRepeatingCharacters
 * @apiNote </br>
 * @since 2023/1/28 12:43
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // 判空
        if (s == null) {
            return 0;
        }
        int length = s.length();
        // 创建哈希表
        Map<Character, Integer> map = new HashMap<>();
        // 左边界
        int leftBorder = -1;
        int result = 0;
        for (int j = 0; j < length; j++) {
            //如果当前元素已存在哈希表中,则更新左边界
            if (map.containsKey(s.charAt(j))) {
                leftBorder = Math.max(leftBorder, map.get(s.charAt(j)));
            }
            // 添加元素
            map.put(s.charAt(j), j);
            // 更新长度
            result = Math.max(j - leftBorder, result);

        }
        return result;
    }
}
