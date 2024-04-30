package com.gewuyou.algorithm.graph;

import com.gewuyou.datastructures.linear.Queue;
import com.gewuyou.datastructures.priority.IndexMinPriorityQueue;

import java.util.Arrays;

/**
 * 最小生成树(贪心算法)prim
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PrimMST
 * @apiNote Prim算法
 * @since 2022/9/10 11:11
 */
public class PrimMST {
    /**
     * 索引代表顶点
     *
     * @apiNote 值表示当前顶点和最小生成树之间的最短边
     */
    private Edge[] edgeTo;
    /**
     * 索引代表顶点
     *
     * @apiNote 值表示当前顶点和最小生成树之间的最短边的权重
     */
    private double[] distTo;
    /**
     * 索引代表顶点
     *
     * @apiNote 如果当前顶点已经在树中，则值为true，否则为false
     */
    private boolean[] marked;
    /**
     * 存放树中顶点与非树中顶点之间的有效横切边
     */
    private IndexMinPriorityQueue<Double> pq;

    /**
     * 根据一副加权无向图，创建最小生成树计算对象
     *
     * @param graph 加权无向图
     * @apiNote
     * @since 2022/9/10 11:14
     */
    public PrimMST(EdgeWeightedGraph graph) {
        //初始化edgeTo
        this.edgeTo = new Edge[graph.V()];
        //初始化distTo
        this.distTo = new double[graph.V()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        //初始化marked
        this.marked = new boolean[graph.V()];
        //初始化pq
        this.pq = new IndexMinPriorityQueue<>(graph.V());
        //默认让顶点0进入到树中，但是树中只有一个顶点0，因此，0顶点默认没有和其他的顶点相连，所以让distTo对应位置处的值存储0.0
        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        //遍历索引最小优先队列，拿到最小和N切边对应的顶点，把该顶点从图中删去并加入到最小生成树中
        // ? 相当于将图切分为在最小生成树中的点和在其之外的点两部分，寻找其最小生成树中顶点横切边中最小权重的边加入到合集中并删除其在另一部分的索引
        while (!pq.isEmpty()) {
            visit(graph, pq.deleteMin());
        }
    }


    /**
     * 将顶点v添加到最小生成树中，并且更新数据
     *
     * @param graph 无向图
     * @param v     顶点v
     * @apiNote
     * @since 2022/9/10 11:16
     */
    private void visit(EdgeWeightedGraph graph, int v) {
        //把顶点v添加到最小生成树中
        marked[v] = true;
        //更新数据
        for (Edge edge : graph.adj(v)) {
            //获取e边的另外一个顶点(当前顶点是v)
            int other = edge.other(v);
            //判断另外一个顶点是不是已经在树中，如果在树中，则不做任何处理，如果不再树中，更新数据
            if (marked[other]) {
                continue;
            }
            //判断边e的权重是否小于从w顶点到树中已经存在的最小边的权重；
            if (edge.weight() < distTo[other]) {
                //更新数据
                edgeTo[other] = edge;

                distTo[other] = edge.weight();

                // 如果该索引处已经有值，需要更改数据
                if (pq.contains(other)) {
                    pq.changeItem(other, edge.weight());
                } else {
                    // 反之则新增
                    pq.insert(other, edge.weight());
                }

            }

        }
    }

    /**
     * 获取最小生成树的所有边
     *
     * @return com.gewuyou.datastructures.linear.Queue<com.gewuyou.algorithm.graph.Edge>
     * @apiNote
     * @since 2022/9/10 11:18
     */
    public Queue<Edge> edges() {
        //创建队列对象
        Queue<Edge> allEdges = new Queue<>();
        //遍历edgeTo数组，拿到每一条边，如果不为null，则添加到队列中
        for (int i = 0; i < edgeTo.length; i++) {
            if (edgeTo[i] != null) {
                allEdges.enqueue(edgeTo[i]);
            }
        }
        return allEdges;
    }
}
