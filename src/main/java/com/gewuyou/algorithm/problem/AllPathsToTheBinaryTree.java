package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 *
 * @author gewuyou
 * @since 2024-04-10 上午11:59:15
 */
public class AllPathsToTheBinaryTree {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        recursion(root, new StringBuilder(), paths);
        return paths;
    }

    private void recursion(TreeNode root, StringBuilder stringBuilder, List<String> paths) {
        if (stringBuilder.length() > 0) {
            stringBuilder.append("->");
        }
        stringBuilder.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(stringBuilder.toString());
            return;
        }
        if (root.left != null) {
            recursion(root.left, new StringBuilder(stringBuilder), paths);
        }
        if (root.right != null) {
            recursion(root.right, new StringBuilder(stringBuilder), paths);
        }
    }
}

