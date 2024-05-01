package com.gewuyou.algorithm.problem;

/**
 * 1232. 缀点成线
 *
 * @author gewuyou
 * @since 2024-05-20 下午1:32:09
 */
public class EmbellishmentIntoALine {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n == 2) {
            return true;
        }
        // 提取第一个点和第二个点的坐标
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        // 遍历所有点，检查是否满足线性方程
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            // 使用乘法避免浮点数误差
            if ((y1 - y0) * (x - x0) != (y - y0) * (x1 - x0)) {
                return false;
            }
        }
        return true;
    }
}
