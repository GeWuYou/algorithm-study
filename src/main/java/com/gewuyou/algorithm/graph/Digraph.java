package com.gewuyou.algorithm.graph;

import com.gewuyou.datastructures.linear.Queue;

/**
 * 有向图
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Digraph
 * @apiNote
 * @since 2022/9/9 9:55
 */
public class Digraph {
    /**
     * 顶点数目
     */
    private final int V;
    /**
     * 边的数目
     */
    private int E;
    /**
     * 邻接表
     */
    private Queue<Integer>[] adj;

    /**
     * 构造方法
     *
     * @param V 顶点
     * @apiNote 创建一个包含V个顶点但不包含边的有向图
     * @since 2022/9/9 10:50
     */
    public Digraph(int V) {
        // 初始化顶点数量
        this.V = V;
        // 初始化边的数量
        this.E = 0;
        // 初始化邻接表
        this.adj = new Queue[V];
        // 让每个索引处存放一个空队列
        for (int v = 0; v <V ; v++) {
            adj[v] = new Queue<>();
        }
    }

    /**
     * 顶点数目
     *
     * @return int
     * @apiNote 获取顶点数目
     * @since 2022/9/9 9:59
     */
    public int V() {
        return V;
    }


    /**
     * 边的数目
     *
     * @return int
     * @apiNote 获取边的数目
     * @since 2022/9/9 10:00
     */
    public int E() {
        return E;
    }

    /**
     * 添加一条边
     *
     * @param v 边v
     * @param w 边w
     * @apiNote 向有向图中添加一条边 v->w
     * @since 2022/9/9 10:00
     */
    public void addEdge(int v, int w) {
        // 只需要顶点w出现在顶点v的邻接表中即可，因为边是有方向的。最终顶点v的邻接表中存储的相邻顶点的含义是v->其它点
        // 直接将w加入v中
        adj[v].enqueue(w);
        // 数目加一
        E++;
    }

    /**
     * 获取由v指出的边所连接的所有顶点
     *
     * @param v 出发点
     * @return com.gewuyou.datastructures.linear.Queue<java.lang.Integer>
     * @apiNote
     * @since 2022/9/9 10:05
     */
    public Queue<Integer> adj(int v) {
        return adj[v];
    }


    /**
     * 该图的反向图
     *
     * @return com.gewuyou.algorithm.graph.Digraph
     * @apiNote
     * @since 2022/9/9 10:06
     */
    private Digraph reverse() {
        // 创建一个有向图对象
        Digraph graph = new Digraph(V);

        for (int v = 0; v < V; v++) {
            // 获取由该顶点v指出的所有边
            for (Integer w : adj[v]) {
                // ? 原图中表示的是由顶点v->w的边
                // 反转索引
                graph.addEdge(w,v);
            }
        }
        return graph;
    }
}
