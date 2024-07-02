package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 274. H 指数
 *
 * @author gewuyou
 * @since 2024-07-26 下午12:00:55
 */
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (citations[i] <= n - i) {
                h = Math.max(h, citations[i]);
            } else {
                h = Math.max(h, n - i);
            }
        }
        return h;
    }
}
