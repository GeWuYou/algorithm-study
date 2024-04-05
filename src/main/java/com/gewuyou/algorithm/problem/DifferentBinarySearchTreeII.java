package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 *
 * @author gewuyou
 * @since 2024-04-28 下午8:56:38
 */
public class DifferentBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        return recursion(1, n);
    }

    private List<TreeNode> recursion(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = recursion(start, i - 1);
            List<TreeNode> rightTrees = recursion(i + 1, end);
            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    // 获得所有可行的左子树集合
                    TreeNode currTree = new TreeNode(i);
                    // 获取所有可行的右子树集合
                    currTree.left = left;
                    currTree.right = right;
                    result.add(currTree);
                }
            }
        }
        return result;
    }
}
