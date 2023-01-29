package com.gewuyou.algorithm.problem;

/**
 * 重建二叉树
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RebuildBinaryTree
 * @apiNote </br>
 * @since 2023/1/6 18:47
 */
public class RebuildBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre == null || vin == null || pre.length == 0 || vin.length == 0) {
            return null;
        }
        return reConstructBinaryTree(pre, vin, 0, pre.length - 1, 0, vin.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin, int preStart, int preEnd, int vinStart, int vinEnd) {
        // 如果索引越界，直接返回空
        if (preStart > preEnd || vinStart > vinEnd) {
            return null;
        }
        // 创建根节点
        TreeNode root = new TreeNode(pre[preStart]);
        // 遍历中序遍历数组找到根节点所在索引
        for (int index = vinStart; index <= vinEnd; index++) {
            if (vin[index] == root.val) {
                // 递归的传入左右索引 index-vinStart = 数据长度
                root.left = reConstructBinaryTree(pre, vin, preStart + 1, preStart + index - vinStart, vinStart, index - 1);
                root.right = reConstructBinaryTree(pre, vin, preStart + index - vinStart + 1, preEnd, index + 1, vinEnd);
            }
        }
        return root;
    }
}
