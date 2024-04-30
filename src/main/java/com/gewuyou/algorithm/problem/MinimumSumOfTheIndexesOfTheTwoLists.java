package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. 两个列表的最小索引总和
 *
 * @author gewuyou
 * @since 2024-04-25 下午1:43:52
 */
public class MinimumSumOfTheIndexesOfTheTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int sum = map.get(list2[i]) + i;
                if (sum < min) {
                    result.clear();
                    result.add(list2[i]);
                    min = sum;
                } else if (sum == min) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {

        String[] list1 = {"happy","sad","good"};
        String[] list2 = {"sad","happy","good"};
        MinimumSumOfTheIndexesOfTheTwoLists solution = new MinimumSumOfTheIndexesOfTheTwoLists();
        String[] result = solution.findRestaurant(list1, list2);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
