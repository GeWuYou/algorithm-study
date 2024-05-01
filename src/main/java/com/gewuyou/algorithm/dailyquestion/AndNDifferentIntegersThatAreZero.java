package com.gewuyou.algorithm.dailyquestion;

/**
 * 1304. 和为零的 N 个不同整数
 *
 * @author gewuyou
 * @since 2024-05-22 下午12:32:17
 */
public class AndNDifferentIntegersThatAreZero {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int mid = n / 2;
        boolean isEven = (n & 1) == 0;
        if (isEven) {
            res[mid] = 0;
        }

        for (int i = 0; i < mid; i++) {
            res[i] = i + 1;
        }

        for (int index = isEven ? mid : mid + 1, diff = isEven ? mid : mid + 1; index < n; index++) {
            res[index] = -res[index - diff];
        }

        return res;
    }

    public static void main(String[] args) {
        AndNDifferentIntegersThatAreZero solution = new AndNDifferentIntegersThatAreZero();
        int[] res = solution.sumZero(4);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
