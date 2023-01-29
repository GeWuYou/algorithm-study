package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * T 秒后青蛙的位置
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PositionOfTheFrogAfterTSeconds
 * @apiNote </br>
 * @since 2023/5/24 13:42
 */
public class PositionOfTheFrogAfterTSeconds {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        // 构建邻接表
        List<Integer>[] adjacencyTables = new ArrayList[n + 1];
        // 创建邻接表空间
        for (int i = 1; i <= n; i++) {
            adjacencyTables[i] = new ArrayList<>();
        }
        // 根据数组生成领接表
        for (int[] edge : edges) {
            adjacencyTables[edge[0]].add(edge[1]);
            adjacencyTables[edge[1]].add(edge[0]);
        }
        // 创建布尔数组判断节点是否访问
        boolean[] visited = new boolean[n + 1];
        return dfs(adjacencyTables, visited, 1, t, target);
    }

    /**
     * 深度优先遍历
     *
     * @param adjacencyTables 邻接表
     * @param visited         辅助布尔数组
     * @param i               当前顶点序号
     * @param t               规定时间
     * @param target          目标节点
     * @return double 概率
     * @apiNote
     * @since 2023/5/24 14:04
     */
    private double dfs(List<Integer>[] adjacencyTables, boolean[] visited, int i, int t, int target) {
        // 计算后序节点
        int next = i == 1 ? adjacencyTables[i].size() : adjacencyTables[i].size() - 1;
        // 如果后续没有节点或者时间为0时终止搜索
        if (t == 0 || next == 0) {
            // 如果当前节点为目标节点则返回1，否则返回0表示这条路线找到概率为0
            return i == target ? 1.0 : 0.0;
        }
        // 设置当前节点为已访问
        visited[i] = true;
        double result = 0.0;
        // 遍历当前节点的后序连接且未访问过的节点，递归的访问并将返回的概率加入result
        for (Integer integer : adjacencyTables[i]) {
            if (!visited[integer]) {
                result += dfs(adjacencyTables, visited, integer, t - 1, target);
            }
        }
        // 计算平均概率
        return result / next;
    }

}
