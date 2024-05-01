package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1002. 查找共用字符
 *
 * @author gewuyou
 * @since 2024-05-13 下午1:24:20
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        // 记录每个字母出现的次数
        words[0].chars().forEach(c ->
                map.put((char) c,
                        map.getOrDefault((char) c, 0) + 1));
        // 遍历每个单词，更新字母出现的次数
        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> temp = new HashMap<>();
            words[i].chars().forEach(c ->
                    temp.put((char) c,
                            temp.getOrDefault((char) c, 0) + 1));
            // 先移除仅有一方持有的字母
            temp.entrySet().removeIf(entry -> !map.containsKey(entry.getKey()));
            map.entrySet().removeIf(entry -> !temp.containsKey(entry.getKey()));
            // 再更新共用字母的次数
            map.entrySet().forEach(entry -> entry.setValue(Math.min(entry.getValue(), temp.get(entry.getKey()))));
        }
        List<String> result = new ArrayList<>();
        // 构造结果
        map.keySet().forEach(key -> {
            for (int i = 0; i < map.get(key); i++) {
                result.add(String.valueOf(key));
            }
        });
        return result;
    }
}
