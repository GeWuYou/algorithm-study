package com.gewuyou.algorithm.dailyquestion;

import java.util.*;

/**
 * 合并相似的物品
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MergeSimilarItems
 * @apiNote </br>
 * @since 2023/2/28 8:22
 */
public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        // 创建哈希表
        Map<Integer, Integer> map = new TreeMap<>();
        // 判断最大长度
        int maxLength = Math.max(items1.length, items2.length);
        // 将数组中的值加入集合中
        for (int i = 0; i < maxLength; i++) {
            add2Map(items1, map, i);
            add2Map(items2, map, i);
        }
        //将集合中的值倒回结果集合
        // 创建结果集合
        List<List<Integer>> results = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            results.add(list);
        }
        return results;
    }

    private void add2Map(int[][] items, Map<Integer, Integer> map, int i) {
        if (i < items.length) {
            map.merge(items[i][0], items[i][1], Integer::sum);
        }
    }
}
