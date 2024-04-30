package com.gewuyou.algorithm.problem;

/**
 * 完全二叉树的判断
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName CompleteBinaryTreeJudgment
 * @apiNote </br>
 * @since 2023/1/3 13:35
 */
public class CompleteBinaryTreeJudgment {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isCompleteTree(TreeNode root) {
        // 空树属于完全二叉树
        if (root == null) {
            return true;
        }
        return judgment(root);
    }

    /**
     * 传入二叉树。判断该树是否为完全二叉树
     *
     * @param root 根节点
     * @return boolean 判断结果
     * @apiNote
     * @since 2023/1/3 13:52
     */
    public boolean judgment(TreeNode root) {
        // 对根节点进行判断
        // 如果该节点不存在左子节点，但存在右子节点，说明不是完全二叉树
        if (root.right != null && root.left == null) {
            return false;
        }
        // 如果该节点存在左子节点，但不存在右子节点，我们需要判断该左子节点是否为叶子节点
        else if (root.left != null && root.right == null) {
            if (root.left.left != null || root.left.right != null) {
                return false;
            }
        }
        // 如果该节点左右子树均存在，需要判断左子树是否为叶子节点，如果是需要判断右子树是否为叶子节点
        else if (root.left != null) {
            if (root.left.left == null || root.left.right == null) {
                if (root.right.left != null || root.right.right != null) {
                    return false;
                }
            }
        }
        // 递归的调用方法，判断左右子树是否满足条件
        if (root.left != null) {
            if (!judgment(root.left)) {
                return false;
            }
        }
        if (root.right != null) {
            return judgment(root.right);
        }
        return true;
    }
}
