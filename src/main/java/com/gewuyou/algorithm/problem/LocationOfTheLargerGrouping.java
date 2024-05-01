package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 830. 较大分组的位置
 *
 * @author gewuyou
 * @since 2024-05-04 上午10:32:18
 */
public class LocationOfTheLargerGrouping {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int n = s.length();
        int start = 0;
        char c = s.charAt(0);
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != c) {
                if (i - start >= 3) {
                    result.add(new ArrayList<>(List.of(start, i-1)));
                }
                start = i;
                c = s.charAt(i);
            }
        }
        if (n - start >= 3) {
            result.add(new ArrayList<>(List.of(start, n-1)));
        }
        return result;
    }

    public static void main(String[] args) {

        String s = "aaa";
        List<List<Integer>> result = new LocationOfTheLargerGrouping().largeGroupPositions(s);
        System.out.println(result);
    }
}
