package com.gewuyou.algorithm.problem;


/**
 * 合并二叉树
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MergeBinaryTree
 * @apiNote </br>
 * @since 2023/1/1 11:56
 */
public class MergeBinaryTree {
    /**
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 代码健壮性检验
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 将两棵二叉树合并
        return merge(t1, t2);
    }

    /**
     * 将传入的两棵树进行合并
     *
     * @param t1 树1
     * @param t2 树2
     * @return com.gewuyou.algorithm.problem.TreeNode
     * @apiNote 使用中序遍历的思想，递归的将两棵树进行合并
     * @since 2023/1/1 12:13
     */

    public TreeNode merge(TreeNode t1, TreeNode t2) {
        // 设t1为主树
        // 如果两棵树的左子树都不为空
        if (t1.left != null && t2.left != null) {
            // 递归的传入两棵树的左子树进行合并
            merge(t1.left, t2.left);
        }
        // 如果t1左子树为空t2不为空
        if (t1.left == null && t2.left != null) {
            // 让t2以t1为主树向t1合并
            t1.left = t2.left;
        }
        // 如果t1不为空t2为空或者二者均为空，则无需任何操作

        // 对根节点进行合并
        t1.val += t2.val;

        // 如果两棵树的右子树都不为空
        if (t1.right != null && t2.right != null) {
            // 递归的传入两棵树的右子树进行合并
            merge(t1.right, t2.right);
        }
        // 如果t1右子树为空t2不为空
        if (t1.right == null && t2.right != null) {
            // 让t2以t1为主树向t1合并
            t1.right = t2.right;
        }
        // 如果t1不为空t2为空或者二者均为空，则无需任何操作
        // 返回t1
        return t1;
    }
}
