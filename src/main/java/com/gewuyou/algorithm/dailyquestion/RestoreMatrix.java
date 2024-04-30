package com.gewuyou.algorithm.dailyquestion;

/**
 * 给定行和列的和求可行矩阵
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RestoreMatrix
 * @apiNote </br>
 * @since 2023/3/14 11:59
 */
public class RestoreMatrix {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        // 思路：找到最小的 rowSum 或 colSum，让它为 x。将该数字放在网格中，然后从 rowSum 和 colSum 中减去 x。
        // 继续，直到满足所有总和。
        // 计算行与列
        int rowLength = rowSum.length;
        int colLength = colSum.length;
        // 创建结果数组
        int [][]result = new int[rowLength][colLength];
        // 被放置的数据需要通过第二小的元素老确定位置
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                result[i][j] = Math.min(rowSum[i],colSum[j]);
                rowSum[i]-=result[i][j];
                colSum[j]-=result[i][j];
            }
        }
        return result;
    }

}
