package com.gewuyou.algorithm.graph;

import com.gewuyou.datastructures.linear.Stack;
import com.gewuyou.datastructures.priority.IndexMinPriorityQueue;

import java.util.Arrays;

/**
 * Dijkstra算法
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName DijkstraSP
 * @apiNote Dijkstra算法
 * @since 2022/9/10 14:35
 */
public class DijkstraSP {
    /**
     * 索引代表顶点
     *
     * @apiNote 值表示从顶点s到当前顶点的最短路径上的最后一条边
     */
    private DirectedEdge[] edgeTo;
    /**
     * 索引代表顶点
     *
     * @apiNote 值从顶点s到当前顶点的最短路径的总权重
     */
    private double[] distTo;
    /**
     * 存放树中顶点与非树中顶点之间的有效横切边
     */
    private IndexMinPriorityQueue<Double> pq;

    /**
     * 根据一副加权有向图G和顶点s，创建一个计算顶点为s的最短路径树对象
     *
     * @param digraph 加权有向图
     * @param s       顶点
     * @apiNote 构造方法
     * @since 2022/9/10 14:38
     */
    public DijkstraSP(EdgeWeightedDigraph digraph, int s) {
        //初始化edgeTo
        this.edgeTo = new DirectedEdge[digraph.V()];
        //初始化distTo
        this.distTo = new double[digraph.V()];
        // 将该数组中的值设置为double的最大值
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        //初始化pq
        this.pq = new IndexMinPriorityQueue<>(digraph.V());
        //找到图G中以顶点s为起点的最短路径树

        //默认让顶点s进入到最短路径树中
        this.distTo[s] = 0.0;
        pq.insert(s, 0.0);
        //遍历pq
        while (!pq.isEmpty()) {
            // 进行放松
            relax(digraph, pq.deleteMin());
        }
    }

    /**
     * 松弛图G中的顶点v
     *
     * @param digraph 图
     * @param v       顶点
     * @apiNote
     * @since 2022/9/10 14:39
     */
    private void relax(EdgeWeightedDigraph digraph, int v) {

        for (DirectedEdge edge : digraph.adj(v)) {
            //获取到该边的终点end
            int end = edge.to();
            // ? 通过松弛技术，判断从起点start到顶点end的最短路径是否需要先从顶点start到顶点end，然后再由顶点v到顶点w
            // 判断当前路径与已知的最短路径总权重大小
            if (distTo(v) + edge.weight() < distTo(end)) {
                // 当前路径并非最短路径，将新路径进行替换
                // 修改顶点s到当前顶点end的最短路径的总权重
                distTo[end] = distTo(v) + edge.weight();
                // 修改最短路径的最后一条边
                edgeTo[end] = edge;
                //判断pq中是否已经存在顶点end，如果存在，则更新权重，如果不存在，则直接添加
                if (pq.contains(end)) {
                    pq.changeItem(end, distTo(end));
                } else {
                    pq.insert(end, distTo(end));
                }
            }
        }
    }

    /**
     * 获取从顶点s到顶点v的最短路径的总权重
     *
     * @param v 顶点
     * @return double
     * @apiNote
     * @since 2022/9/10 14:40
     */
    public double distTo(int v) {
        return distTo[v];
    }

    /**
     * 判断从顶点s到顶点v是否可达
     *
     * @param v 顶点
     * @return boolean
     * @apiNote 是返回true反之返回false
     * @since 2022/9/10 14:41
     */
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * 查询从起点s到顶点v的最短路径中所有的边
     *
     * @param v 顶点
     * @return com.gewuyou.datastructures.linear.Stack<com.gewuyou.algorithm.graph.DirectedEdge>
     * @apiNote
     * @since 2022/9/10 14:41
     */
    public Stack<DirectedEdge> pathTo(int v) {
        //判断从顶点s到顶点v是否可达，如果不可达，直接返回null
        if (!hasPathTo(v)) {
            return null;
        }
        //创建队列对象
        Stack<DirectedEdge> allEdges = new Stack<>();

        while (true) {
            // 找到上一条边
            DirectedEdge preEdge = edgeTo[v];
            if (preEdge == null) {
                break;
            }
            // 将边放入栈
            allEdges.push(preEdge);

            // 变换preEdge的值
            v = preEdge.from();
        }
        return allEdges;
    }

}
