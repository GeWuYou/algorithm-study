package com.gewuyou.algorithm.problem;

/**
 * 对称二叉树
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SymmetricalBinaryTree
 * @apiNote </br>
 * @since 2023/4/12 21:08
 */
public class SymmetricalBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode root1, TreeNode root2) {
        // 递归末尾
        if (root1 == null && root2 == null) {
            return true;
        }
        // 如果其中有一个节点为空说明该树不对称
        if (root1 == null || root2 == null) {
            return false;
        }
        // 判断当前值是否相同
        if (root1.val != root2.val) {
            return false;
        }
        // 向左右递归
        return check(root1.left, root2.right) && check(root1.right, root2.left);
    }
}
