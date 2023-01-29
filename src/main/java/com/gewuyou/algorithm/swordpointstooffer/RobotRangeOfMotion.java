package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 机器人的运动范围
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RobotRangeOfMotion
 * @apiNote </br>
 * @since 2023/1/31 12:29
 */
public class RobotRangeOfMotion {
    public int movingCount(int m, int n, int k) {
        // 创建方格
        boolean[][] checkered = new boolean[m][n];
        // 起点为(0,0)
        return dfs(0, 0, k, checkered);
    }

    /**
     * 深度优先遍历
     *
     * @param row        行
     * @param column     列
     * @param upperLimit 上限值
     * @param checkered  方格
     * @return int 访问的方格数
     * @apiNote
     * @since 2023/1/31 12:38
     */
    public int dfs(int row, int column, int upperLimit, boolean[][] checkered) {
        // 如果行列越界或者超过上限或者当前位置已被访问直接返回方格数
        if (row > checkered.length - 1 || row < 0 || column > checkered[0].length - 1 || column < 0 || upperLimit < (row / 10 + row % 10 + column / 10 + column % 10) || checkered[row][column]) {
            return 0;
        }
        // 记录方格数
        int count = 1;
        // 修改当前访问状态
        checkered[row][column] = true;
        // 向上下左右进行递归搜索
        // 上
        count += dfs(row - 1, column, upperLimit, checkered);
        // 下
        count += dfs(row + 1, column, upperLimit, checkered);
        // 左
        count += dfs(row, column - 1, upperLimit, checkered);
        // 右
        count += dfs(row, column + 1, upperLimit, checkered);
        // 返回结果
        return count;
    }
}
