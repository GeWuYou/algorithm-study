package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 434. 字符串中的单词数
 *
 * @author gewuyou
 * @since 2024-04-16 上午10:00:29
 */
public class TheNumberOfWordsInTheString {
    public int countSegments(String s) {
        if(s.isEmpty()){
            return 0;
        }
        String[] strings = s.trim().split(" ");
        List<String> list = new ArrayList<>();
        for (String str : strings) {
            if (!str.isEmpty()&&!" ".equals(str)) {
                list.add(str);
            }
        }
        return list.size();
    }
}
