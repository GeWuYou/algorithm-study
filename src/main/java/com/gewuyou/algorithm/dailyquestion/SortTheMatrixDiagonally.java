package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1329. 将矩阵按对角线排序
 *
 * @author gewuyou
 * @since 2024-04-29 下午1:04:01
 */
public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // 提取对角线数组
        List<List<Integer>> diagonalList = new ArrayList<>();
        int x = 0;
        int y = m - 1;

        for (int k = 0; k < m + n - 1; k++) {
            int i = x;
            int j = y;
            List<Integer> diagonal = new ArrayList<>();
            while (i < n && j < m) {
                diagonal.add(mat[j][i]);
                i++;
                j++;
            }
            diagonalList.add(diagonal);
            if (y == 0 && x < n) {
                x++;
            }
            if (y > 0) {
                y--;
            }
        }
        // 对对角线数组进行排序
        for (List<Integer> diagonal : diagonalList) {
            Collections.sort(diagonal);
        }
        // 填充矩阵
        int[][] result = new int[m][n];
        x = 0;
        y = m - 1;
        for (int k = 0; k < m + n - 1; k++) {
            List<Integer> diagonal = diagonalList.get(k);
            int i = x;
            int j = y;
            while (i < n && j < m) {
                result[j][i] = diagonal.get(i - x);
                i++;
                j++;
            }
            if (y == 0 && x < n) {
                x++;
            }
            if (y > 0) {
                y--;
            }
        }
        return result;
    }
}
