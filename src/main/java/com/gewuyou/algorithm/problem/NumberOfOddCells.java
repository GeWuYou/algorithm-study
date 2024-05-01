package com.gewuyou.algorithm.problem;

/**
 * 1252. 奇数值单元格的数目
 *
 * @author gewuyou
 * @since 2024-05-20 下午1:43:40
 */
public class NumberOfOddCells {
    public int oddCells(int m, int n, int[][] indices) {
        int res = 0;
        int [] rowCount = new int[m];
        int [] colCount = new int[n];
        for (int[] index : indices) {
            rowCount[index[0]]++;
            colCount[index[1]]++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(((rowCount[i]+colCount[j])&1)==1){
                    res++;
                }
            }
        }
        return res;
    }
}
