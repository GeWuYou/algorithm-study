package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 1051. 高度检查器
 *
 * @author gewuyou
 * @since 2024-05-16 下午3:14:52
 */
public class AltitudeChecker {
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] copy = new int[heights.length];
        System.arraycopy(heights, 0, copy, 0, heights.length);
        Arrays.sort(copy);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        AltitudeChecker checker = new AltitudeChecker();
        int count = checker.heightChecker(heights);
        System.out.println(count);
    }
}
