package com.gewuyou.algorithm.swordpointstooffer;

import com.gewuyou.algorithm.problem.TreeNode;

/**
 * 平衡二叉树
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BalancedBinaryTree
 * @apiNote </br>
 * @since 2023/2/3 11:29
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        // 空树属于平衡二叉树
        if (root == null) {
            return true;
        }
        // 默认根节点深度为0
        // 创建变量接收返回最大深度
        int leftDepth = BinaryTreeDepth(root.left, 1);
        int rightDepth = BinaryTreeDepth(root.right, 1);
        // 判断子树中是否存在不满足平衡二叉树条件的情况
        if (leftDepth == -1 || rightDepth == -1) {
            return false;
        }
        // 返回最终结果
        return Math.abs(leftDepth - rightDepth) <= 1;
    }

    /**
     * 计算传入平衡二叉树的最大深度
     *
     * @param root  根节点
     * @param depth 当前深度
     * @return int
     * @apiNote 在计算深度的同时会判断本层节点是否符合平衡二叉树的条件，如果满足返回最大深度，反之返回-1
     * @since 2023/1/3 14:37
     */
    public int BinaryTreeDepth(TreeNode root, int depth) {
        // 如果传入的节点为空节点，说明到达最底层了直接返回传入深度
        if (root == null) {
            return depth;
        }
        // 如果深度为-1，直接返回
        if (depth == -1) {
            return depth;
        }
        // 当前深度自增
        depth++;
        // 创建变量接收返回最大深度
        int leftDepth = BinaryTreeDepth(root.left, depth);
        int rightDepth = BinaryTreeDepth(root.right, depth);
        // 判断当前节点是否符合平衡二叉树条件
        if (Math.abs(leftDepth - rightDepth) > 1) {
            // 不满足返回-1
            return -1;
        } else {
            // 满足条件返回最大深度
            return Math.max(leftDepth, rightDepth);
        }
    }
}
