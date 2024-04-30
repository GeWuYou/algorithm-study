package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 解密消息
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName DecryptMessage
 * @apiNote </br>
 * @since 2023/2/1 16:42
 */
public class DecryptMessage {
    public String decodeMessage(String key, String message) {
        char start = 'a';
        Map<Character,Character> chart = new HashMap<>();
        // 创建哈希表来记录字母出现的顺序
        for (int i = 0; i < key.length(); i++) {
            if(' '==key.charAt(i)||chart.get(key.charAt(i))!=null){
                continue;
            }
            chart.put(key.charAt(i),start++);
        }
        StringBuilder result = new StringBuilder();
        // 解析数据
        for (int i = 0; i < message.length(); i++) {
            if(' '==message.charAt(i)){
                result.append(' ');
                continue;
            }
            result.append(chart.get(message.charAt(i)));
        }
        return result.toString();
    }
}
