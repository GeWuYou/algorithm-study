package com.gewuyou.algorithm.graph;

/**
 * 加权有向图边
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName DirectedEdge
 * @apiNote 有向边
 * @since 2022/9/10 13:48
 */
public class DirectedEdge {
    /**
     * 起点
     */
    private final int start;
    /**
     * 终点
     */
    private final int end;
    /**
     * 当前边的权重
     */
    private final double weight;

    /**
     * 通过顶点v和w，以及权重weight值构造一个边对象
     *
     * @param start 起点
     * @param end 终点
     * @param weight 当前边的权重
     * @apiNote
     * @since 2022/9/10 13:54
     */
    public DirectedEdge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    /**
     * 获取边的权重值
     *
     * @return double
     * @apiNote
     * @since 2022/9/10 13:55
     */
    public double weight(){
        return weight;
    }

    /**
     * 获取有向边的起点
     *
     * @return int
     * @apiNote
     * @since 2022/9/10 13:55
     */
    public int from(){
        return start;
    }

    /**
     * 获取有向边的终点
     *
     * @return int
     * @apiNote
     * @since 2022/9/10 13:55
     */
    public int to(){
        return end;
    }
}
