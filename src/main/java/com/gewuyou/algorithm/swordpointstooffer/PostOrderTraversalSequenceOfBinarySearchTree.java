package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PostOrderTraversalSequenceOfBinarySearchTree
 * @apiNote </br>
 * @since 2023/2/6 13:12
 */
public class PostOrderTraversalSequenceOfBinarySearchTree {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int start, int end) {
        // 越界说明递归结束
        if (start >= end) {
            return true;
        }
        // 寻找第一个比根节点大的数值
        int index = start;
        while (postorder[index] < postorder[end]) {
            index++;
        }
        // 标记位置
        int mid = index;
        // 判断右子树是否符合要求 (右子树所有节点必须大于根节点)(左子树在查找的过程中已经确定均小于根节点)
        while (postorder[index] > postorder[end]) {
            index++;
        }
        // 以mid为分界线进行划分
        return index == end && verifyPostorder(postorder, start, mid - 1) && verifyPostorder(postorder, mid, end - 1);
    }
}
