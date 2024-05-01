package com.gewuyou.algorithm.problem;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author gewuyou
 * @since 2024-05-01 下午1:59:09
 */
public class PrefaceConstructsTheBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd) {
        // 判断是否越界

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 创建根节点 前序遍历首节点为根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        // 遍历中序数组找到根节点所在位置
        int inIndex = 0;
        while(inorder[inIndex]!=root.val){
            inIndex++;
        }
        // 计算截取的长度
        int leftLength = inIndex - inStart;
        // 递归创建左子树
        root.left = buildTree(preorder, preStart + 1, preStart + leftLength, inorder, inStart, inStart + leftLength - 1);
        // 递归创建右子树
        root.right = buildTree(preorder, preStart + leftLength + 1, preEnd, inorder, inStart + leftLength + 1, inEnd);
        return root;
    }
}