package com.gewuyou.algorithm.problem;

/**
 * 124. 二叉树中的最大路径和
 *
 * @author gewuyou
 * @since 2024-08-02 下午2:02:11
 */
public class TheMaximumPathInTheBinaryTreeIsSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return maxSum;
    }

    private int getMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树的最大路径和
        int leftSum = Math.max(getMaxPathSum(root.left),0);
        // 计算右子树的最大路径和
        int rightSum = Math.max(getMaxPathSum(root.right),0);
        // 计算通过当前节点的最大路径和
        int currentSum = root.val + leftSum + rightSum;
        // 更新全局最大路径和
        maxSum = Math.max(maxSum, currentSum);
        // 返回当前节点的最大路径和
        return root.val + Math.max(leftSum, rightSum);
    }
}
