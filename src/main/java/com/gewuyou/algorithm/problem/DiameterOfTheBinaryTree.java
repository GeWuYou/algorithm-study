package com.gewuyou.algorithm.problem;

/**
 * 543. 二叉树的直径
 *
 * @author gewuyou
 * @since 2024-04-21 下午12:42:56
 */
public class DiameterOfTheBinaryTree {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        // 计算左子树的链长并加上连接当前节点的这条边数
        int left = dfs(root.left)+1;
        // 计算右子树的链长并加上连接当前节点的这条边数
        int right = dfs(root.right)+1;
        ans = Math.max(ans,left+right);
        return Math.max(left,right);
    }
}
