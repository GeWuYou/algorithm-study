package com.gewuyou.algorithm.problem;

/**
 * 二叉树的最小深度
 *
 * @author gewuyou
 * @since 2024-04-06 下午6:24:39
 */
public class MinimumDepthOfTheBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
