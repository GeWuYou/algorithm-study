package com.gewuyou.algorithm.problem;

/**
 * 二叉树中和为某一值的路径(一)
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BinaryTreeNeutralizesPath2SomeValue1
 * @apiNote </br>
 * @since 2022/12/31 12:25
 */
public class BinaryTreeNeutralizesPath2SomeValue1 {
    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // 将直接传空的情况拒之门外
        if (root == null) {
            return false;
        }
        // 设置初始值
        int value = 0;
        return hasPathSum(root, value, sum);
    }

    /**
     * 使用深度优先遍历计算路径值
     *
     * @param root  根节点
     * @param value 路径值
     * @param sum   目标值
     * @apiNote
     * @since 2022/12/31 13:07
     */
    public boolean hasPathSum(TreeNode root, int value, int sum) {
        // 将当前值加入路径值中
        value += root.val;
        // 判断当前节点是否为子节点，如果是，则进行比较
        if (root.left == null && root.right == null) {
            return value == sum;
        }
        // 设置左右结果
        boolean leftResult = false;
        boolean rightResult = false;
        // 当前节点不是子节点(n1,n2)
        if (root.right != null) {
            rightResult = hasPathSum(root.right, value, sum);
        }
        if (root.left != null) {
            leftResult = hasPathSum(root.left, value, sum);
        }
        // 返回结果
        return rightResult||leftResult;
    }
}
