package com.gewuyou.algorithm.graph;

/**
 * 有向环
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName DirectedCycle
 * @apiNote 检测有向环
 * @since 2022/9/9 11:44
 */
public class DirectedCycle {

    /**
     * 索引代表顶点，值表示当前顶点是否已经被搜索
     */
    private boolean[] marked;
    /**
     * 记录图中是否有环
     */
    private boolean hasCycle;
    /**
     * 索引代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在搜索的有向路径上
     */
    private boolean[] onStack;

    /**
     * 检测环对象
     *
     * @param graph 要检测的环对象
     * @apiNote 创建一个检测环对象，检测图G中是否有环
     * @since 2022/9/9 11:47
     */
    public DirectedCycle(Digraph graph) {
        // 初始化marked数组
        this.marked = new boolean[graph.V()];
        // 初始化hasCycle
        this.hasCycle = false;
        // 初始化onStack数组
        this.onStack = new boolean[graph.V()];

        // 找到图中每一个顶点，让每一个顶点作为入口，调用一次dfs进行搜索
        for (int v = 0; v < graph.V(); v++) {
            if (hasCycle()) {
                return;
            }
            // 判断如果当前顶点还没有搜索过则调用dfs进行搜索
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    /**
     * 基于深度优先搜索，检测图G中是否有环
     *
     * @param digraph 被检测的图
     * @param v
     * @apiNote
     * @since 2022/9/9 11:48
     */
    private void dfs(Digraph digraph, int v) {
        // 把当前顶点标识为已搜索
        marked[v] = true;
        // 把当前顶点进栈
        onStack[v] = true;
        // 进行深度搜索
        for (Integer d : digraph.adj(v)) {
            // 判断如果当前顶点w没有被搜索过，则继续递归调用待发送方法完成深度优先搜索
            if (!marked[d]) {
                dfs(digraph, d);
            }
            // 判断当前顶点w是否已经在栈中，如果已经在栈中，说明该顶点在之前处于正在搜索的状态，而现在又要搜索一次就证明了，图中有环当前w为入口
            if (onStack[d]) {
                hasCycle = true;
                return;
            }
        }
        // 把当前顶点出栈
        // ? 出栈是为了把当前顶点进行深度搜索的栈清空，留给下一个顶点使用
        onStack[v] = false;
    }

    /**
     * 判断判断当前有向图中是否有环
     *
     * @return boolean
     * @apiNote
     * @since 2022/9/9 13:39
     */
    public boolean hasCycle() {
        return hasCycle;
    }
}
