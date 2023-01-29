package com.gewuyou.algorithm.dailyquestion;

/**
 * 最大的以 1 为边界的正方形
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Largest1BorderedSquare
 * @apiNote </br>
 * @since 2023/2/17 11:08
 */
public class Largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        // 行数
        int rows = grid.length;
        // 列数
        int columns = grid[0].length;
        int[][] left = new int[rows + 1][columns + 1];
        int[][] up = new int[rows + 1][columns + 1];
        int result = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (grid[i-1][j-1]==1) {
                    left[i][j] =left[i][j-1]+1;
                    up[i][j] =up[i-1][j] +1;
                    int tempResult = Math.min(left[i][j],up[i][j]);
                    while (left[i-tempResult+1][j]<tempResult||up[i][j-tempResult+1]<tempResult){
                        tempResult--;
                    }
                    result = Math.max(result,tempResult);
                }
            }
        }
        return result*result;
    }
}
