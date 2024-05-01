package com.gewuyou.algorithm.dailyquestion;

/**
 * 1652. 拆炸弹
 *
 * @author gewuyou
 * @since 2024-05-05 下午12:06:28
 */
public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        if (k == 0) {
            return result;
        }
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int index = i;
                for (int j = 0; j < k; j++) {
                    index++;
                    index %= n;
                    result[i] += code[index];
                }
            }
        } else {
            k = -k;
            for (int i = 0; i < n; i++) {
                int index = i;
                for (int j = 0; j < k; j++) {
                    index--;
                    if (index < 0) {
                        index = n - 1;
                    }
                    result[i] += code[index];
                }
            }
        }
        return result;
    }
}
