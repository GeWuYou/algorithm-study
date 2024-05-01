package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.problem.TreeNode;

/**
 * 965. 单值二叉树
 *
 * @author gewuyou
 * @since 2024-05-11 下午12:46:50
 */
public class SingleValuedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }

}
