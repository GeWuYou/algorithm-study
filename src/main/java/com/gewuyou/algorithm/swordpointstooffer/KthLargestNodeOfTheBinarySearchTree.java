package com.gewuyou.algorithm.swordpointstooffer;

import com.gewuyou.algorithm.problem.TreeNode;

/**
 * 二叉搜索树的第 k 大节点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName KthLargestNodeOfTheBinarySearchTree
 * @apiNote </br>
 * @since 2023/2/1 16:14
 */
public class KthLargestNodeOfTheBinarySearchTree {
    /**
     * 第k大
     */
    int k;
    /**
     * 结果值
     */
    int result;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        reversionInorderTraversalIn(root);
        return result;
    }

    public void reversionInorderTraversalIn(TreeNode root) {
        if(root==null){
            return;
        }
        // 向右递归
        reversionInorderTraversalIn(root.right);
        // 当k为0时停止遍历
        if(k==0){
            return;
        }
        // 记录每次遍历的结果值
        if(--k==0){
            result = root.val;
        }
        // 向左递归
        reversionInorderTraversalIn(root.left);
    }
}
