package com.gewuyou.algorithm.problem;

/**
 * 翻转二叉树
 *
 * @author gewuyou
 * @since 2024-04-08 下午2:03:25
 */
public class FlipTheBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

}
