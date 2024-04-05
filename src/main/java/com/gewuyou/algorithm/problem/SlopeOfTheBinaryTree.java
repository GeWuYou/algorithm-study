package com.gewuyou.algorithm.problem;

/**
 * 563. 二叉树的坡度
 *
 * @author gewuyou
 * @since 2024-04-23 下午4:37:30
 */
public class SlopeOfTheBinaryTree {
    private int podu = 0;
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        return podu +=Math.abs(left-right);
    }
    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树总和
        int left = sum(root.left);
        // 计算右子树总和
        int right = sum(root.right);
        // 计算当前节点的坡度
        podu += Math.abs(left - right);
        // 返回当前节点的总和
        return left + right + root.val;
    }
}
