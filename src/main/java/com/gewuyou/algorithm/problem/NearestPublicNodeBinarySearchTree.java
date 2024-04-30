package com.gewuyou.algorithm.problem;

/**
 * 二叉搜索树的最近公共祖宗节点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NearestPublicNodeBinarySearchTree
 * @apiNote </br>
 * @since 2023/1/4 19:54
 */
public class NearestPublicNodeBinarySearchTree {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @param p    int整型
     * @param q    int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        // 判断目标值大小
        if (p > q) {
            return findTheAncestorNode(root, p, q);
        } else {
            return findTheAncestorNode(root, q, p);
        }
        // 二叉搜索树的最近公共节点
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
    public int findTheAncestorNode(TreeNode root, int p, int q) {
        // 目标值同时在左边
        if (root.val > p && root.val > q) {
            // 递归的调用方法向左继续查找
            return findTheAncestorNode(root.left, p, q);
        }
        // 目标值同时在右边
        else if (root.val < p && root.val < q) {
            // 递归的调用方法向右继续查找
            return findTheAncestorNode(root.right, p, q);
        }
        // 如果目标值小的在左，大的在右，说明，当前节点即是祖先节点(查找分叉点)
        else if (root.val < p && root.val > q) {
            return root.val;
        }
        // 如果目标值大的等于节点值，返回该目标值，如果目标值小的等于节点值，也返回该节点目标值
        else {
            // 如果目标值大的等于节点值，返回该目标值
            if (root.val == p) {
                return p;
            }
            // 如果目标值小的等于节点值，也返回该节点目标值(当然两个目标值相等的情况不可能发生)
            return q;
        }
    }
}