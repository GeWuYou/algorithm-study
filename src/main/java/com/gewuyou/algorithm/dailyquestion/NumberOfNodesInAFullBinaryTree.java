package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.problem.TreeNode;

/**
 * 完全二叉树的节点个数
 *
 * @author gewuyou
 * @since 2024-04-08 下午1:23:07
 */
public class NumberOfNodesInAFullBinaryTree {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
      int leftCount = countNodes(root.left);
      int rightCount = countNodes(root.right);
      return leftCount + rightCount + 1;
    }


}
