package com.gewuyou.algorithm.graph;

import com.gewuyou.datastructures.linear.Queue;

/**
 * 图搜索
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BreadthFirstSearch
 * @apiNote 广度优先搜索
 * @since 2022/9/8 11:10
 */
public class BreadthFirstSearch {

    /**
     * 索引代表顶点
     *
     * @apiNote 值代表顶点是否已经被搜索
     */
    private boolean[] marked;

    /**
     * 记录右多少个顶点与s顶点相通
     */
    private int count;

    /**
     * 用来存储待搜索邻接表的点
     */
    private Queue<Integer> waitSearch;

    public BreadthFirstSearch(Graph graph, int s) {
        // 初始化marked数组
        this.marked = new boolean[graph.V()];
        // 初始化跟顶点s相通的顶点的数量
        this.count = 0;
        this.waitSearch = new Queue<Integer>();

        bfsearch(graph,s);
    }

    /**
     * 查找图中v顶点的所有相通点
     *
     * @param graph 图
     * @param v     顶点
     * @apiNote 使用广度优先搜索找出grap中v顶点的所有相通顶点
     * @since 2022/9/8 11:15
     */
    private void bfsearch(Graph graph, int v) {
        // 把当前顶点v标识为已搜索
        marked[v]= true;
        // 顶点v进入队列待搜索
        waitSearch.enqueue(v);
        // 通过循环，如果我们的队列不为空则从队列中弹出一个待搜索的顶点进行搜索
        while (!waitSearch.isEmpty()){
            // 弹出一个待搜索的顶点
            Integer wait = waitSearch.dequeue();
            // 遍历wait顶点的邻接表
            for (Integer w : graph.adjacency(wait)) {
                if(!marked[w]){
                    waitSearch.enqueue(w);
                }
            }
            if (!marked[wait]) {
                bfsearch(graph,wait);
            }
        }
        count++;
    }

    /**
     * 判断w顶点与s顶点是否相通
     *
     * @param w 顶点w
     * @return boolean
     * @apiNote
     * @since 2022/9/8 10:15
     */
    public boolean marked(int w) {
        return marked[w];
    }

    /**
     * 获取域顶点s相通的所有顶点的个数
     *
     * @return int
     * @apiNote
     * @since 2022/9/8 10:17
     */
    public int count() {
        return count;
    }
}
