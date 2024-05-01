package com.gewuyou.algorithm.problem;

/**
 * 129. 求根节点到叶节点数字之和
 *
 * @author gewuyou
 * @since 2024-05-06 下午4:57:24
 */
public class SumNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumNumbers(root,0);
        return sum;
    }

    private void  sumNumbers(TreeNode root, int preSum) {
        if (root.left==null&&root.right==null){
            sum+=root.val+preSum;
        }
        preSum+=root.val;
        if (root.left!=null){
            sumNumbers(root.left,preSum*10);
        }
        if (root.right!=null){
            sumNumbers(root.right,preSum*10);
        }

    }
}
