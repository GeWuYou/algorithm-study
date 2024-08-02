package com.gewuyou.algorithm.dailyquestion;

/**
 * 3128. 直角三角形
 *
 * @author gewuyou
 * @since 2024-08-02 下午12:16:14
 */
public class RightAngledTriangle {
    private long count = 0;

    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 计算每个点上下左右的1的个数
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        // 计算每个点上边的1的个数 i 列 j 行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 1) {
                    up[j][i] = j > 0 ? up[j - 1][i] + 1 : 1;
                } else {
                    up[j][i] = j > 0 ? up[j - 1][i] : 0;
                }
            }
        }
        // 计算每个点下边的1的个数
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[j][i] == 1) {
                    down[j][i] = j < m - 1 ? down[j + 1][i] + 1 : 1;
                } else {
                    down[j][i] = j < m - 1 ? down[j + 1][i] : 0;
                }
            }
        }
        // 计算每个点左边的1的个数 i 行 j 列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                } else {
                    left[i][j] = j > 0 ? left[i][j - 1] : 0;
                }
            }
        }
        // 计算每个点右边的1的个数
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    right[i][j] = j < n - 1 ? right[i][j + 1] + 1 : 1;
                } else {
                    right[i][j] = j < n - 1 ? right[i][j + 1] : 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 要组成直角三角形要求上下和左右都得有一条边
                    long topLeft = ((long) up[i][j] - 1) * ((long) left[i][j] - 1);
                    long topRight = ((long) up[i][j] - 1) * ((long) right[i][j] - 1);
                    long bottomLeft = ((long) down[i][j] - 1) * ((long) left[i][j] - 1);
                    long bottomRight = ((long) down[i][j] - 1) * ((long) right[i][j] - 1);
                    count += (topLeft + topRight + bottomLeft + bottomRight);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0}, {0, 1, 1}, {0, 1, 0}};
        RightAngledTriangle rightAngledTriangle = new RightAngledTriangle();
        System.out.println(rightAngledTriangle.numberOfRightTriangles(grid));
    }
}
