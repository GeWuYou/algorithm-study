package com.gewuyou.algorithm.graph;

/**
 * 加权边
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Edge
 * @apiNote 加权边
 * @since 2022/9/9 15:03
 */
public class Edge implements Comparable<Edge> {
    /**
     * 顶点一
     */
    private final int v;
    /**
     * 顶点二
     */
    private final int w;
    /**
     * 当前边的权重
     */
    private final double weight;

    /**
     * 通过顶点v和w，以及权重weight值构造一个边对象
     *
     * @param v      顶点一
     * @param w      顶点二
     * @param weight 当前边的权重
     * @apiNote 构造函数
     * @since 2022/9/9 15:07
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取边的权重值
     *
     * @return double
     * @apiNote
     * @since 2022/9/9 15:08
     */
    public double weight() {
        return weight;
    }

    /**
     * 获取边上的一个点
     *
     * @return int
     * @apiNote
     * @since 2022/9/9 15:09
     */
    public int either() {
        return v;
    }

    /**
     * 获取边上除了顶点vertex外的另外一个顶点
     *
     * @param vertex 顶点
     * @return int
     * @apiNote
     * @since 2022/9/9 15:09
     */
    public int other(int vertex) {
        return v ^ w ^ vertex;
    }


    @Override
    public int compareTo(Edge edge) {
        // 使用一个变量记录比较的结果
        int compare2;

        if (edge.weight < weight) {
            // 如果当前边的比较权值大的话则让compare2等于1
            compare2 = 1;
        } else if (edge.weight > weight) {
            // 如果当前边的比较权值小的话则compare2等于-1
            compare2 = -1;
        } else {
            // 如果二者相等，则让compare2等于0
            compare2 = 0;
        }
        return compare2;
    }
}
