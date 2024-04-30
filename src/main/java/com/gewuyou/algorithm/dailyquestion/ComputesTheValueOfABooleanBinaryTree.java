package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.problem.TreeNode;

/**
 * 计算布尔二叉树的值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ComputesTheValueOfABooleanBinaryTree
 * @apiNote </br>
 * @since 2023/2/6 10:11
 */
public class ComputesTheValueOfABooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        // 如果当前为叶子节点
        if (root.val == 0) {
            return false;
        }
        if (root.val == 1) {
            return true;
        }

        // 如果当前为分支节点
        boolean left = true;
        boolean right = true;

        // 向左递归
        left = evaluateTree(root.left);

        // 向右递归
        right = evaluateTree(root.right);

        // 判断当前操作 逻辑或操作
        if(root.val==2){
            return left||right;
        }

        // 逻辑与操作
        return left&&right;
    }
}
