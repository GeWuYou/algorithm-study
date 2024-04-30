package com.gewuyou.algorithm.problem;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * @author gewuyou
 * @since 2024-04-21 上午10:43:08
 */
public class MinimumAbsoluteDifferenceBinarySearchTree {
    private int min;
    private int prev;

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        // 给pre初始化一个比较大的负数,省去if判断(不能最小值,会溢出)
        prev = Integer.MIN_VALUE / 2;
        inorderTraversal(root);
        return min;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);

        min = Math.min(min, root.val - prev);

        prev = root.val;

        inorderTraversal(root.right);
    }
}
