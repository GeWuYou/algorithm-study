package com.gewuyou.algorithm.dailyquestion;

import java.util.*;

/**
 * 1122. 数组的相对排序
 *
 * @author gewuyou
 * @since 2024-05-17 下午5:45:33
 */
public class RelativeOrderingOfArrays {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr2) {
            set.add(i);
        }
        int[] res = new int[arr1.length];
        for (int i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int index = 0;
        for (int i : arr2) {
            int count = map.getOrDefault(i, 0);
            while (count > 0) {
                res[index++] = i;
                count--;
            }
        }
        int start = index;
        for (int i : arr1) {
            if (!set.contains(i)) {
                res[index++] = i;
            }
        }
        Arrays.sort(res, start, index);
        return res;
    }

    public static void main(String[] args) {
        RelativeOrderingOfArrays solution = new RelativeOrderingOfArrays();
        int[] arr1 = {2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31};
        int[] arr2 = {2, 42, 38, 0, 43, 21};
        int[] res = solution.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }
}
