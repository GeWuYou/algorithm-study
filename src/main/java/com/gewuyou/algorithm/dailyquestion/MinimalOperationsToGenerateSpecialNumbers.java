package com.gewuyou.algorithm.dailyquestion;

/**
 * 2844. 生成特殊数字的最少操作
 *
 * @author gewuyou
 * @since 2024-07-25 上午9:49:16
 */
public class MinimalOperationsToGenerateSpecialNumbers {
    public int minimumOperations(String num) {
        boolean find0 = false;
        boolean find5 = false;
        int n = num.length();
        for (int i = n-1; i >=0; i--) {
            // 如果遇到 0 或 5
            if (num.charAt(i) == '0' || num.charAt(i) == '5') {
                // 如果在这之前遇到过 0，则将这之前的 0，当前的数字，
                // 以及当前的数字以左的数字都保留，其他的数字删除。记 num 长度为 n，当前下标为 i，最少操作数即为 n−i−2。
                if (find0) {
                    return n - i - 2;
                }
                // 如果在这之前没有遇到过 0，则标记一下状态，表示遇到了 0 或 5。
                if (num.charAt(i) == '0') {
                    find0 = true;
                } else {
                    find5 = true;
                }
            } else
                // 如果遇到 2 或 7
                if (num.charAt(i) == '2' || num.charAt(i) == '7') {
                    // 如果在这之前遇到过 5，则将这之前的 5，当前的数字，以及当前的数字以左的数字都保留，其他的数字删除。
                    // 记 num 长度为 n，当前下标为 i，最少操作数即为 n−i−2。
                    if (find5) {
                        return n - i - 2;
                    }
                }
        }
        // 如果遇到过0，则最少操作数为 n−1，否则最少操作数为 n。
        if (find0) {
            return n - 1;
        }
        return n;
    }
}
