package com.gewuyou.algorithm.graph;

import com.gewuyou.datastructures.linear.Queue;

/**
 * 加权无向图
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName EdgeWeightedGraph
 * @apiNote 加权无向图
 * @since 2022/9/9 15:26
 */
public class EdgeWeightedGraph {
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
    private Queue<Edge>[] adj;

    /**
     * 创建一个含有V个顶点的空加权无向图
     *
     * @param V 顶点数量
     * @apiNote 构造函数
     * @since 2022/9/9 15:29
     */
    public EdgeWeightedGraph(int V) {
        //初始化顶点数量
        this.V = V;
        //初始化边的数量
        this.E = 0;
        //初始化邻接表
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Edge>();
        }

    }

    /**
     * 获取图中顶点的数量
     *
     * @return int
     * @apiNote
     * @since 2022/9/9 15:29
     */
    public int V() {
        return V;
    }

    /**
     * 获取图中边的数量
     *
     * @return int
     * @apiNote
     * @since 2022/9/9 15:30
     */
    public int E() {
        return E;
    }

    /**
     * 向加权无向图中添加一条边e
     *
     * @param e 新边
     * @apiNote
     * @since 2022/9/9 15:30
     */
    public void addEdge(Edge e) {
        //需要让边e同时出现在e这个边的两个顶点的邻接表中
        // 顶点一
        int v = e.either();
        // 顶点二
        int w = e.other(v);

        adj[v].enqueue(e);
        adj[w].enqueue(e);
        //边的数量+1
        E++;
    }

    /**
     * 获取和顶点v关联的所有边
     *
     * @param v 顶点
     * @return com.gewuyou.datastructures.linear.Queue<com.gewuyou.algorithm.graph.Edge>
     * @apiNote
     * @since 2022/9/9 15:31
     */
    public Queue<Edge> adj(int v) {
        return adj[v];
    }

    /**
     * 获取加权无向图的所有边
     *
     * @return com.gewuyou.datastructures.linear.Queue<com.gewuyou.algorithm.graph.Edge>
     * @apiNote
     * @since 2022/9/9 15:31
     */
    public Queue<Edge> edges() {

        //创建一个队列对象，存储所有的边
        Queue<Edge> allEdges = new Queue<>();
        //遍历图中的每一个顶点，找到该顶点的邻接表，邻接表中存储了该顶点关联的每一条边
        // ? 因为这是无向图，所以同一条边同时出现在了它关联的两个顶点的邻接表中，需要让一条边只记录一次；
        for (int v = 0; v < V; v++) {
            //遍历v顶点的邻接表，找到每一条和v关联的边
            for (Edge edge : adj[v]) {
                // 获取当前边关联的两个顶点
                if (edge.other(v) < v) {
                    // 只有当点前点大于另一个顶点时才加入到allEdges中
                    allEdges.enqueue(edge);
                }
            }
        }
        return allEdges;
    }
}
