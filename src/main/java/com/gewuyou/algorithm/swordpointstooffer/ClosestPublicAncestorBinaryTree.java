package com.gewuyou.algorithm.swordpointstooffer;

import com.gewuyou.algorithm.problem.TreeNode;

/**
 * 二叉树的最近公共祖先
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ClosestPublicAncestorBinaryTree
 * @apiNote </br>
 * @since 2023/2/4 13:25
 */
public class ClosestPublicAncestorBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 当前节点为空或者当前节点等于目标节点中的一个则直接返回
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树中没有返回任何目标节点则说明目标节点都在右子树上，返回向右递归的结果
        if (left == null) {
            return right;
        }
        // 如果右子树中没有返回任何目标节点则说明目标节点都在左子树上看，返回向左递归的结果
        if (right == null) {
            return left;
        }
        // 如果向左向右递归的结果均存在，说明当前节点即为祖先节点
        return root;
    }

}
