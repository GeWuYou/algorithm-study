package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 884. 两句话中的不常见单词
 *
 * @author gewuyou
 * @since 2024-05-06 下午3:19:52
 */
public class UncommonWordsInTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        Map<String,Boolean> map = new HashMap<>();
        for (String s : words1) {
            if (map.containsKey(s)) {
                map.put(s,false);
            }else {
                map.put(s,true);
            }
        }
        for (String s : words2) {
            if (map.containsKey(s)) {
                map.put(s,false);
            }else {
                map.put(s,true);
            }
        }

        return map.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}
