package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 二进制矩阵中的最短路径
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ShortestPathInABinaryMatrix
 * @apiNote </br>
 * @since 2023/5/26 9:34
 */
public class ShortestPathInABinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // 判断初始节点
        if (grid[0][0] == 1) {
            return -1;
        }
        // 矩阵边长
        int length = grid.length;
        // 创建标志数组记录步长
        int[][] visited = new int[length][length];
        for (int i = 0; i < length; i++) {
           Arrays.fill(visited[i],Integer.MAX_VALUE);
        }
        // 创建队列，将起点加入队列中
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        // 标记起点为被访问过
        visited[0][0] = 1;
        // 使用队列进行深度优先遍历
            while (!queue.isEmpty()) {
                int[] ints = queue.poll();
                int x = ints[0];
                int y = ints[1];
                // 判断是否到达终点
                if (x == length - 1 && y == length - 1) {
                    return visited[x][y];
                }
                // 判断四面八方的节点是否满足条件
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        // 越界
                        if (x + dx < 0 || x + dx >= length || y + dy < 0 || y + dy >= length) {
                            continue;
                        }
                        // 单元格值不为0或者已经被访问 由于未被访问的单元格在辅助数组中的值为Int最大值，所以凡是小于当前节点+1的都是被访问过的
                        if (grid[x + dx][y + dy] != 0 || visited[x+dx][y+dy]<=visited[x][y]+1) {
                            continue;
                        }
                        visited[x+dx][y+dy]=visited[x][y]+1;
                        queue.offer(new int[]{x + dx, y + dy});
                    }
                }
            }
        return -1;
    }
}
