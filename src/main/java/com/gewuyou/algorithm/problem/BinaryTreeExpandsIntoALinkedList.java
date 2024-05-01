package com.gewuyou.algorithm.problem;

/**
 * 114. 二叉树展开为链表
 *
 * @author gewuyou
 * @since 2024-05-04 下午12:08:15
 */
public class BinaryTreeExpandsIntoALinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 左子树为空，则直接返回
        if (left == null) {
            return;
        }
        // 将左子树连接到根节点的右侧
        root.right = left;
        // 将根节点的左子树设置为null
        root.left = null;
        // 找到左子树的最右节点
        while (left.right!= null) {
            left = left.right;
        }
        // 将原来的右子树连接到左子树的最右节点
        left.right = right;
    }

}
