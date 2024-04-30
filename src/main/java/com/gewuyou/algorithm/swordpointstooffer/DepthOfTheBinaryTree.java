package com.gewuyou.algorithm.swordpointstooffer;

import com.gewuyou.algorithm.problem.TreeNode;

/**
 * 二叉树的深度
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName DepthOfTheBinaryTree
 * @apiNote </br>
 * @since 2023/2/3 11:11
 */
public class DepthOfTheBinaryTree {
    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        //如果当前面节点为空则返回0
        if (root == null) {
            return 0;
        }
        // 返回左右子树最大深度+1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
