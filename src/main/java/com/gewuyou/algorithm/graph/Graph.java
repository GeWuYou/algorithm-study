package com.gewuyou.algorithm.graph;

import com.gewuyou.datastructures.linear.Queue;

/**
 * 图
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Graph
 * @apiNote 无向图
 * @since 2022/9/7 19:32
 */
public class Graph {
    /**
     * 记录顶点的数量
     */
    private final int V;

    /**
     * 记录边的数量
     */
    private int count;

    /**
     * 领接表
     */
    private Queue<Integer>[] adjacency;

    /**
     * 创建一个包含V个顶点但不包含边的图
     *
     * @param v 顶点
     */
    public Graph(int v) {

        // 初始化顶点数量
        V = v;
        // 初始化边的数量
        count = 0;
        // 初始化邻接表
        this.adjacency = new Queue[V];

        for (int i = 0; i < adjacency.length; i++) {
            adjacency[i] = new Queue<Integer>();
        }
    }

    /**
     * 获取顶点数量
     *
     * @return int
     * @apiNote 获取当前图顶点数量
     * @since 2022/9/7 19:37
     */
    public int V() {
        return V;
    }

    /**
     * 获取边的数量
     *
     * @return int
     * @apiNote 获取当前图边的数量
     * @since 2022/9/7 19:38
     */
    public int count() {
        return count;
    }

    /**
     * 添加边
     *
     * @param v 边v
     * @param w 边w
     * @apiNote 向图中添加一条边 v-w
     * @since 2022/9/7 19:39
     */
    public void addEdge(int v, int w) {
        // 在无向图中，边是没有方向的，所有该边既可以说是从v到w的边，也可以说是从w到v的边,
        // 因此需要让w出现在v的邻接表中，并且也要让v出现在w的邻接表上
        adjacency[v].enqueue(w);
        adjacency[w].enqueue(v);
        count++;
    }

    /**
     * 获取和顶点v相邻的所有顶点
     *
     * @param v 顶点v
     * @return com.gewuyou.datastructures.linear.Queue<java.lang.Integer>
     * @apiNote
     * @since 2022/9/7 19:41
     */
    public Queue<Integer> adjacency(int v) {
        return adjacency[v];
    }
}
