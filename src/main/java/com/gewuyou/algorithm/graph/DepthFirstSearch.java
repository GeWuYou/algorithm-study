package com.gewuyou.algorithm.graph;

/**
 * 图
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName DepthFirstSearch
 * @apiNote 图_深度优先搜索
 * @since 2022/9/8 10:04
 */
public class DepthFirstSearch {

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

    public DepthFirstSearch(Graph graph, int s) {
        // 初始化marked数组
        this.marked = new boolean[graph.V()];
        // 初始化跟顶点s相通的顶点的数量
        this.count = 0;

        dfs(graph, s);
    }

    /**
     * 查找图中v顶点的所有相通点
     *
     * @param graph 图
     * @param v     顶点v
     * @apiNote 使用深度优先搜索找出grap中v顶点的所有相通顶点
     * @since 2022/9/8 10:09
     */
    private void dfs(Graph graph, int v) {
        // 标记v为已搜索
        marked[v] = true;
        for (Integer w : graph.adjacency(v)) {
            // 判断当前w顶点有没有被搜索过，如果没有被搜索过则递归调用dfs方法进行深度搜索
            if(!marked(w)){
                dfs(graph,w);
            }
        }
        // 相通顶点数量加一
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
