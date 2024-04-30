package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 455. 分发饼干
 *
 * @author gewuyou
 * @since 2024-04-17 上午11:06:02
 */
public class DistributeCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        // 两个数组的指针
        int i = 0, j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}
