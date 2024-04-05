package com.gewuyou.algorithm.problem;

/**
 * 700. 二叉搜索树中的搜索
 *
 * @author gewuyou
 * @since 2024-04-29 下午1:36:33
 */
public class SearchInTheBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
