package com.gewuyou.algorithm.graph;

import com.gewuyou.datastructures.linear.Queue;

/**
 * 加权有向图
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName EdgeWeightedDigraph
 * @apiNote 加权有向图
 * @since 2022/9/10 13:56
 */
public class EdgeWeightedDigraph {
    /**
     * 顶点总数
     */
    private final int V;
    /**
     * 边的总数
     */
    private int E;
    /**
     * 邻接表
     */
    private Queue<DirectedEdge>[] adj;

    /**
     * 创建一个含有V个顶点的空加权有向图
     *
     * @param V 顶点
     * @apiNote
     * @since 2022/9/10 13:59
     */
    public EdgeWeightedDigraph(int V) {
        //初始化顶点数量
        this.V = V;
        //初始化边的数量
        this.E = 0;
        //初始化邻接表
        this.adj = new Queue[V];
        //存储空队列
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<>();
        }
    }

    /**
     * 获取图中顶点的数量
     *
     * @return int
     * @apiNote
     * @since 2022/9/10 13:59
     */
    public int V() {
        return V;
    }

    /**
     * 获取图中边的数量
     *
     * @return int
     * @apiNote
     * @since 2022/9/10 13:59
     */
    public int E() {
        return E;
    }

    /**
     * 向加权有向图中添加一条边e
     *
     * @param edge 有向加权边
     * @apiNote
     * @since 2022/9/10 14:00
     */
    public void addEdge(DirectedEdge edge) {
        // ? 边edge是有方向的，所以只需要让edge出现在起点的邻接表中即可
        // 获取起点
        int start = edge.from();
        // 将edge加入到起点的邻接表中
        adj[start].enqueue(edge);
        // 让边的数量+1
        E++;
    }

    /**
     * 获取由顶点v指出的所有的边
     *
     * @param v 顶点
     * @return com.gewuyou.datastructures.linear.Queue<com.gewuyou.algorithm.graph.DirectedEdge>
     * @apiNote
     * @since 2022/9/10 14:01
     */
    public Queue<DirectedEdge> adj(int v) {
        return adj[v];
    }

    /**
     * 获取加权有向图的所有边
     *
     * @return com.gewuyou.datastructures.linear.Queue<com.gewuyou.algorithm.graph.DirectedEdge>
     * @apiNote
     * @since 2022/9/10 14:02
     */
    public Queue<DirectedEdge> edges() {
        //遍历图中的每一个顶点，得到该顶点的邻接表，遍历得到每一条边，添加到队列中返回即可
        Queue<DirectedEdge> allEdges = new Queue<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge edge : adj[v]) {
                allEdges.enqueue(edge);
            }
        }
        return allEdges;
    }
}
