package com.gewuyou.algorithm.graph;

import com.gewuyou.datastructures.linear.Stack;

/**
 * 路径查找
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName DepthFirstPaths
 * @apiNote 基于深度优先的路径查找
 * @since 2022/9/8 14:10
 */
public class DepthFirstPaths {

    /**
     * 索引代表顶点，值表示当前顶点是否已经被搜索
     */
    private boolean[] marked;
    /**
     * 起点
     */
    private int start;
    /**
     * 索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
     */
    private int[] edgeTo;

    /**
     * 构造深度优先搜索对象
     *
     * @param graph 图
     * @param start 起点
     * @apiNote 使用深度优先搜索找出G图中起点为s的所有路径
     * @since 2022/9/8 14:13
     */
    public DepthFirstPaths(Graph graph, int start) {
        // 初始化marked数组
        this.marked = new boolean[graph.V()];
        // 初始化起点
        this.start = start;
        // 初始化edge数组
        this.edgeTo = new int[graph.V()];
        // 调用方法进行搜索
        dfs(graph, start);
    }


    /**
     * 找出graph图中v顶点的所有相邻顶点
     *
     * @param graph 图
     * @param v     顶点v
     * @apiNote 使用深度优先搜索找出G图中v顶点的所有相邻顶点
     * @since 2022/9/8 14:14
     */
    private void dfs(Graph graph, int v) {
        // 把v标识为已搜索
        marked[v] = true;
        // 遍历顶点v的邻接表。拿到每一个相邻的顶点、继续递归搜索
        for (Integer w : graph.adjacency(v)) {
            // 如果顶点没有被搜索，则继续递归搜索
            if (!marked[w]) {
                // 到达顶点w的路径上的最后一个顶点是v
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    /**
     * 判断w顶点与s顶点是否存在路径
     *
     * @param v 顶点v
     * @return boolean
     * @apiNote
     * @since 2022/9/8 14:34
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 找出从起点s到顶点v的路径
     *
     * @param v 顶点v
     * @return Stack<Integer>
     * @apiNote (就是该路径经过的顶点)
     * @since 2022/9/8 14:15
     */
    public Stack<Integer> pathTo(int v) {
        // 判断二者是否存在路径
        if (!hasPathTo(v)) {
            return null;
        }

        // 创建栈对象，保存路径中所有顶点
        Stack<Integer> path = new Stack<>();

        // 通过循环从顶点v开始，一直往前找，到找到起点位置
        for (int i = v; i != start; i = edgeTo[i]) {
            path.push(i);
        }
        // 遍历完，此时已经回到起点了，再将起点加入到path中
        path.push(start);
        return path;
    }
}
