package com.gewuyou.algorithm.swordpointstooffer;

import com.gewuyou.algorithm.problem.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NearestCommonAncestorBinarySearchTree
 * @apiNote </br>
 * @since 2023/2/4 12:15
 */
public class NearestCommonAncestorBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 判断传入的两个节点是否存在父子关系
        if (p.left == q || p.right == q) {
            return p;
        }
        if (q.left == p || q.right == p) {
            return q;
        }
        // 两个节点相对的处于左右两边
        if (p.val > q.val) {
            return findTheAncestorNode(root, p, q);
        } else {
            return findTheAncestorNode(root, q, p);
        }
    }

    /**
     * 传入根节点与两个目标值，返回祖先节点值
     *
     * @param root 根节点
     * @param p    目标1 默认更大
     * @param q    目标2 默认更小
     * @return int 祖先节点值
     * @apiNote
     * @since 2023/1/4 20:11
     */
    public TreeNode findTheAncestorNode(TreeNode root, TreeNode p, TreeNode q) {
        // 两个目标值同时在左边
        if (root.val > p.val && root.val > q.val) {
            // 向左递归
            return findTheAncestorNode(root.left, p, q);
        }
        // 两个目标值同时在右边
        if (root.val < p.val && root.val < q.val) {
            // 向右递归
            return findTheAncestorNode(root.right, p, q);
        }
        // 如果目标值小的在左，大的在右，说明，当前节点即是祖先节点(查找分叉点)或者节点值等于两个目标节点中的一个，说明该节点即为祖先节点
        return root;
    }
}
