package com.gewuyou.algorithm.swordpointstooffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 只出现一次的字符
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName CharactersThatOccurOnlyOnce
 * @apiNote </br>
 * @since 2023/1/25 12:18
 */
public class CharactersThatOccurOnlyOnce {
    public char firstUniqChar(String s) {
        Map<Character,Integer> letter = new LinkedHashMap<>(26);
        // 构建哈希表
        for (int i = 0; i < s.length(); i++) {
            if(letter.get(s.charAt(i))!=null){
                letter.put(s.charAt(i),letter.get(s.charAt(i))+1);
            }else {
                letter.put(s.charAt(i),1);
            }
        }
        // 返回第一个只出现一次的字符
        return letter.keySet().stream().filter(character -> letter.get(character) == 1).findFirst().orElse(' ');
    }
}
