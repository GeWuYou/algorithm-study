package com.gewuyou.algorithm.problem;

/**
 * 二叉树的镜像
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MirrorBinaryTree
 * @apiNote </br>
 * @since 2023/1/2 12:37
 */
public class MirrorBinaryTree {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror(TreeNode pRoot) {
        // 代码健壮性
        if (pRoot == null) {
            return null;
        }
        exchange(pRoot);
        return pRoot;
    }

    /**
     * 交换二叉树左右节点
     *
     * @param root 根节点
     * @apiNote
     * @since 2023/1/2 12:40
     */
    public void exchange(TreeNode root) {
        // 先递归的调用方法，传入左子树
        if (root.left != null) {
            exchange(root.left);
        }
        // 再递归的调用方法，传入右子树
        if (root.right != null) {
            exchange(root.right);
        }
        if (root.left == null && root.right != null) {
            // 如果当前节点无左子树，存在右子树
            // 将右子树取代左子树，右子树置空
            root.left = root.right;
            root.right = null;
        } else if (root.right == null && root.left != null) {
            // 如果当前节点有左子树，无右子树
            // 将左子树取代右子树，左子树置空
            root.right = root.left;
            root.left = null;
        } else if (root.right != null) {
            // 当前节点左右子树均存在
            // 交换左右子树
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        // 如果左右子树都不存在则无动作
    }
}
