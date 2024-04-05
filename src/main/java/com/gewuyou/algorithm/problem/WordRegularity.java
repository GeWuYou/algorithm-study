package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词规律
 *
 * @author gewuyou
 * @since 2024-04-11 下午1:23:40
 */
public class WordRegularity {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> pMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();
        int n = pattern.length();
        String[] strArr = s.split(" ");
        if(n!=strArr.length){
            return false;
        }
        for (int i = 0; i < n; i++) {
            char key = pattern.charAt(i);
            String value = strArr[i];
            if(pMap.containsKey(key)){
                if(!pMap.get(key).equals(value)){
                    return false;
                }
            }else {
                pMap.put(key,value);
            }
            if(sMap.containsKey(value)){
                if(!sMap.get(value).equals(key)){
                    return false;
                }
            }else {
                sMap.put(value,key);
            }
        }
        return true;
    }
}
