package com.gewuyou.algorithm.graph;

import com.gewuyou.datastructures.linear.Stack;

/**
 * 顶点排序
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName DepthFirstOrder
 * @apiNote 基于深度优先搜索的顶点排序
 * @since 2022/9/9 14:22
 */
public class DepthFirstOrder {
    /**
     * 索引代表顶点，值表示当前顶点是否已经被搜索
     */
    private boolean[] marked;
    /**
     * 使用栈，存储顶点序列
     */
    private Stack<Integer> reversePost;

    /**
     * 创建一个检测环对象
     *
     * @param digraph 有向图
     * @apiNote 创建一个检测环对象，检测图G中是否有环
     * @since 2022/9/9 14:26
     */
    public DepthFirstOrder(Digraph digraph) {
        //初始化marked数组
        this.marked = new boolean[digraph.V()];
        //初始化reversePost栈
        this.reversePost = new Stack<>();
        //遍历图中的每一个顶点，让每个顶点作为入口，完成一次深度优先搜索
        for (int v = 0; v < digraph.V(); v++) {
            if(!marked[v]){
                dfs(digraph,v);
            }
        }
    }


    /**
     * 基于深度优先搜索，把顶点排序
     *
     * @param digraph 有向图
     * @param v 顶点v
     */
    private void dfs(Digraph digraph, int v) {
        //标记当前v已经被搜索
        marked[v] = true;
        //通过循环深度搜索顶点v
        for (Integer d : digraph.adj(v)) {
            // 如果还未搜索递归调用dfs进行搜索
            if (!marked[d]) {
                dfs(digraph, d);
            }
        }
        //让顶点v进栈
        reversePost.push(v);
    }

    /**
     * 获取顶点线性序列
     *
     * @return com.gewuyou.datastructures.linear.Stack<java.lang.Integer>
     * @apiNote
     * @since 2022/9/9 14:28
     */
    public Stack<Integer> reversePost() {
        return reversePost;
    }
}
