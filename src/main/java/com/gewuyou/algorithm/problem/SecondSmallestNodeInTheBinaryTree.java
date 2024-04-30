package com.gewuyou.algorithm.problem;

/**
 * 671. 二叉树中第二小的节点
 *
 * @author gewuyou
 * @since 2024-04-27 下午1:04:47
 */
public class SecondSmallestNodeInTheBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int min) {
        if (root == null) {
            return -1;
        }
        if (root.val > min) {
            return root.val;
        }

        int left = dfs(root.left, min);

        int right = dfs(root.right, min);

        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }

        return Math.min(left, right);

    }

}
