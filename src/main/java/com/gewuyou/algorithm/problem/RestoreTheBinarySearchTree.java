package com.gewuyou.algorithm.problem;

/**
 * 99. 恢复二叉搜索树
 *
 * @author gewuyou
 * @since 2024-04-30 下午1:02:26
 */
public class RestoreTheBinarySearchTree {
    private TreeNode firstError = null;
    private TreeNode secondError = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // 中序遍历，找到两个错误节点
        inorderTraversal(root);

        // 交换两个错误节点的值
        int temp = firstError.val;
        firstError.val = secondError.val;
        secondError.val = temp;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // 左子树
        inorderTraversal(root.left);

        // 当前节点
        if (prev != null && prev.val > root.val) {
            // 找到第一个错误节点，即较大的节点
            if (firstError == null) {
                firstError = prev;
            }
            // 找到第二个错误节点，即较小的节点
            secondError = root;
        }
        prev = root;

        // 右子树
        inorderTraversal(root.right);
    }
}
