package com.gewuyou.algorithm.dailyquestion;

import java.util.Collections;
import java.util.TreeMap;

/**
 * 身高排序
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName HeightSorting
 * @apiNote </br>
 * @since 2023/4/25 10:56
 */
public class HeightSorting {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }
        n = 0;
        for (String value : map.values()) {
            names[n] = value;
            n++;
        }
        return names;
    }
}
