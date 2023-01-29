package com.gewuyou.algorithm.swordpointstooffer;

import com.gewuyou.algorithm.problem.TreeNode;

/**
 * 重建二叉树
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RebuildBinaryTree
 * @apiNote </br>
 * @since 2023/2/6 10:34
 */
public class RebuildBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 判空
        if (preorder == null || inorder.length == 0) {
            return null;
        }
        return reConstructBinaryTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin, int preStart, int preEnd, int vinStart, int vinEnd) {
        // 判断是否越界
        if (preEnd < preStart || vinEnd < vinStart) {
            return null;
        }
        // 创建根节点
        TreeNode root = new TreeNode(pre[preStart]);
        // 在中序遍历数组中寻找根节点
        for (int index = vinStart; index <= vinEnd; index++) {
            if (vin[index] == root.val) {
                // 建立左子树 (preStart + 1)移动先序索引 (preStart + index - vinStart) 计算先序序列中左子节点数量将其切割
                root.left = reConstructBinaryTree(pre, vin, preStart + 1, preStart + index - vinStart, vinStart, index - 1);
                // 建立右子树 (preStart + index - vinStart+1) 传入剩余右子节点起始索引
                root.right = reConstructBinaryTree(pre, vin, preStart + index - vinStart + 1, preEnd, index + 1, vinEnd);
            }
        }
        return root;
    }
}
