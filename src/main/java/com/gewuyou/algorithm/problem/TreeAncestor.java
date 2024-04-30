package com.gewuyou.algorithm.problem;

/**
 * 树节点的第 K 个祖先
 *
 * @author gewuyou
 * @since 2024-04-06 下午3:24:40
 */
public class TreeAncestor {
    /**
     * 用来记录节点i的第2^x次方的父节点的位置
     */
    private int[][] dp;

    private int high;

    public TreeAncestor(int n, int[] parent) {
        // 计算二叉树高度
        high = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        dp = new int[n][high];
        // 初始化dp
        for (int i = 0; i < parent.length; i++) {
            // 初始化2^0次方处的父节点
            dp[i][0] = parent[i];
        }
        // 把其它2^i次方处的祖父节点找到
        for (int j = 1; j < high; j++) {
            for (int k = 0; k < n; k++) {
                // dp[0][0]是dp[0][1]的父节点
                int pre = dp[k][j - 1];
                dp[k][j] = -1 == pre ? -1 : dp[pre][j - 1];
            }
        }
    }
    public int getKthAncestor(int node, int k) {

        for (int i = 0; i < high; i++) {
            if(node==-1){
                return -1;
            }
            if((k&(1<<i))!=0){
                // 寻找第k个祖父节点的话，实际上是拆分成找第2^i次的值
                node = dp[node][i];
            }
        }
        return node;
    }
}