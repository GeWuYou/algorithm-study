package com.gewuyou.algorithm.dailyquestion;

/**
 * 2391. 收集垃圾的最少总时间
 *
 * @author gewuyou
 * @since 2024-05-11 上午10:01:09
 */
public class MinimumTotalTimeToCollectGarbage {
    public int garbageCollection(String[] garbage, int[] travel) {
        int m = 0;
        int p = 0;
        int g = 0;
        int indexM = 0;
        int indexP = 0;
        int indexG = 0;
        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'M') {
                    for (int k = indexM; k < i; k++) {
                        m += travel[k];
                    }
                    indexM = i;
                    m++;
                }

                if (garbage[i].charAt(j) == 'P') {
                    for (int k = indexP; k < i; k++) {
                        m += travel[k];
                    }
                    indexP = i;
                    p++;
                }

                if (garbage[i].charAt(j) == 'G') {
                    for (int k = indexG; k < i; k++) {
                        m += travel[k];
                    }
                    indexG = i;
                    g++;
                }
            }
        }
        return m + p + g;
    }

    public static void main(String[] args) {
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2,4,3};
        MinimumTotalTimeToCollectGarbage solution = new MinimumTotalTimeToCollectGarbage();
        int result = solution.garbageCollection(garbage, travel);
        System.out.println(result);
    }
}
