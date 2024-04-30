package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName LongestSubstringWithoutRepeatedCharacters
 * @apiNote </br>
 * @since 2023/3/11 15:11
 */
public class LongestSubstringWithoutRepeatedCharacters {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length==0){
            return 0;
        }
        // 创建哈希表
        Map<Character, Integer> map = new HashMap<>();
        // 创建左边界
        int leftBorder = -1;
        int result = 0;
        for (int i = 0; i < length; i++) {
            Integer index = map.get(s.charAt(i));
            // 如果该元素存在则更新左边界
            if(index!=null) {
               leftBorder = Math.max(leftBorder,index);
            }
            // 更新哈希表
            map.put(s.charAt(i),i);
            // 更新长度
            result = Math.max(i-leftBorder,result);
        }
        return result;
    }
}
