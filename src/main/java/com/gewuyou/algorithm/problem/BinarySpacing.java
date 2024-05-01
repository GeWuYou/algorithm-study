package com.gewuyou.algorithm.problem;

/**
 * 868. 二进制间距
 *
 * @author gewuyou
 * @since 2024-05-05 下午1:32:09
 */
public class BinarySpacing {
    public int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);

        int max = 0;
        int index = -1;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                if (index != -1) {
                    max = Math.max(max, i - index);
                }
                index = i;
            }
        }
        return max;
    }
}
