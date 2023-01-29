package com.gewuyou.algorithm.dailyquestion;

/**
 * 攻城要塞
 *
 * @author gewuyou
 */
public class CaptureForts {
    public int captureForts(int[] forts) {
        int count = 0;
        int n = forts.length;
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (pre >= 0 && forts[i] != forts[pre]) {
                    count = Math.max(count, i - pre - 1);
                }
                pre = i;
            }

        }
        return count;
    }
}
