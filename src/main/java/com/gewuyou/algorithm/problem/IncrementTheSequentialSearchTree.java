package com.gewuyou.algorithm.problem;

/**
 * 897. 递增顺序搜索树
 *
 * @author gewuyou
 * @since 2024-05-07 下午6:40:49
 */
public class IncrementTheSequentialSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode dummy = new TreeNode(0);
        increasingBSTHelper(root, dummy);
        return dummy.right;
    }

    private TreeNode increasingBSTHelper(TreeNode root, TreeNode dummy) {
        // 中序遍历
        if (root == null) {
            return dummy;
        }

        // 向左递归返回 dummy 节点
        dummy = increasingBSTHelper(root.left, dummy);
        root.left = null;
        dummy.right = root;
        dummy = root;
        // 向右递归
        return increasingBSTHelper(root.right, dummy);
    }


}
