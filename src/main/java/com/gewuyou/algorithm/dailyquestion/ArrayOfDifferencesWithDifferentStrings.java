package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 差值数组不同的字符串
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ArrayOfDifferencesWithDifferentStrings
 * @apiNote </br>
 * @since 2023/5/25 13:26
 */
public class ArrayOfDifferencesWithDifferentStrings {
    public static String oddString(String[] words) {
        Map<List<Integer>,Integer[]> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j < words[0].length(); j++) {
                list.add(words[i].charAt(j)-words[i].charAt(j-1));
            }
            Integer[] integers = map.get(list);
            if(integers==null){
                map.put(list,new Integer[]{1,i});
            }else {
                integers[0]++;
                integers[1] = i;
                map.put(list,integers);
            }
        }
        // 判断结果
        for (Map.Entry<List<Integer>, Integer[]> entry : map.entrySet()) {
            if(entry.getValue()[0]==1){
                return words[entry.getValue()[1]];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"aaa","bob","ccc","ddd"};
        oddString(words);
    }
}
