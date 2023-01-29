package com.gewuyou.algorithm.graph;

import com.gewuyou.datastructures.linear.Queue;
import com.gewuyou.datastructures.priority.MinPriorityQueue;
import com.gewuyou.algorithm.uf.UF_Tree_Weighted;

/**
 * 最小生成树(贪心算法)Kruskal
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName KruskalMST
 * @apiNote Kruskal算法
 * @since 2022/9/10 13:07
 */
public class KruskalMST {
    /**
     * 保存最小生成树的所有边
     */
    private Queue<Edge> mst;
    /**
     * 索引代表顶点
     *
     * @apiNote 使用uf.connect(v, w)可以判断顶点v和顶点w是否在同一颗树中，使用uf.union(v,w)可以把顶点v所在的树和顶点w所在的树合并
     */
    private UF_Tree_Weighted uf;
    /**
     * 存储图中所有的边，使用最小优先队列，对边按照权重进行排序
     */
    private MinPriorityQueue<Edge> pq;

    /**
     * 根据一副加权无向图，创建最小生成树计算对象
     *
     * @param graph 加权无向图
     * @apiNote
     * @since 2022/9/10 13:10
     */
    public KruskalMST(EdgeWeightedGraph graph) {

        //初始化mst
        this.mst = new Queue<Edge>();
        //初始化uf
        this.uf = new UF_Tree_Weighted(graph.V());
        //初始化pq
        this.pq = new MinPriorityQueue<>(graph.E());
        //把图中所有的边存储到pq中
        for (Edge edge : graph.edges()) {
            pq.insert(edge);
        }
        //遍历pq队列，拿到最小权重的边，进行处理 处理完后最小生成树的边数量总是图节点的数量减一
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            //找到权重最小的边
            Edge min = pq.deleteMin();
            //找到该边的两个顶点
            // 顶点一
            int either = min.either();
            // 顶点二
            int other = min.other(either);
            //判断这两个顶点是否已经在同一颗树中，如果在同一颗树中，则不对该边做处理，
            if (uf.connected(either, other)) {
                continue;
            } else {
                // 如果不在一棵树中，则让这两个顶点属于的两棵树合并成一棵树
                uf.union(either, other);
            }
            //让边min进入到mst队列中
            mst.enqueue(min);
        }
    }

    //获取最小生成树的所有边
    public Queue<Edge> edges() {
        return mst;
    }
}
