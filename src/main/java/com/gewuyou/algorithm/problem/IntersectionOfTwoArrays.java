package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 349. 两个数组的交集
 *
 * @author gewuyou
 * @since 2024-04-13 上午9:43:13
 */
public class IntersectionOfTwoArrays {
    // public int[] intersection(int[] nums1, int[] nums2) {
    //     Set<Integer> set = new HashSet<>();
    //     for (int num : nums1) {
    //         set.add(num);
    //     }
    //     Set<Integer> result = new HashSet<>();
    //     for (int i : nums2) {
    //         if (set.contains(i)) {
    //             result.add(i);
    //         }
    //     }
    //     return result.stream().mapToInt(Integer::intValue).toArray();
    // }
    public int[] intersection(int[] nums1, int[] nums2) {
        int [] hashArray = new int[1001];
        for (int j : nums1) {
            hashArray[j] = 1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if (hashArray[i] == 1) {
                result.add(i);
                hashArray[i]++;
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
