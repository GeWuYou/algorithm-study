package com.gewuyou.algorithm.graph;

import com.gewuyou.datastructures.linear.Stack;

/**
 * 拓扑排序
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TopoLogical
 * @apiNote 调用有向环进行判断再调用顶点排序，以实现拓扑排序
 * @since 2022/9/9 14:39
 */
public class TopoLogical {

    /**
     * 顶点的拓扑排序
     */
    private Stack<Integer> order;

    /**
     * 构造拓扑排序对象
     *
     * @param digraph 有向图
     * @apiNote 构造方法
     * @since 2022/9/9 14:41
     */
    public TopoLogical(Digraph digraph) {
        //创建一个检测有向环的对象
        DirectedCycle cycle = new DirectedCycle(digraph);
        //判断G图中有没有环，如果没有环，则进行顶点排序：创建一个顶点排序对象
        if (!cycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
            order = depthFirstOrder.reversePost();
        }
    }

    /**
     * 判断图G是否有环
     *
     * @return boolean
     * @apiNote
     * @since 2022/9/9 14:42
     */
    private boolean isCycle() {
        return order == null;
    }

    /**
     * 获取拓扑排序的所有顶点
     *
     * @return com.gewuyou.datastructures.linear.Stack<java.lang.Integer>
     * @apiNote
     * @since 2022/9/9 14:42
     */
    public Stack<Integer> order() {
        return order;
    }
}
