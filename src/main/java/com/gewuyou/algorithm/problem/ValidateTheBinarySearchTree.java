package com.gewuyou.algorithm.problem;

/**
 * 98. 验证二叉搜索树
 *
 * @author gewuyou
 * @since 2024-04-29 下午4:22:26
 */
public class ValidateTheBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        // 检查当前节点的值是否在有效范围内
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        // 递归检查左子树和右子树
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
