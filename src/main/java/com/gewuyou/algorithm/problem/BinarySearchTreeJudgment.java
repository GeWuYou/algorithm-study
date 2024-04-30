package com.gewuyou.algorithm.problem;

/**
 * 二叉搜索树的判断
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BinarySearchTreeJudgment
 * @apiNote </br>
 * @since 2023/1/2 13:23
 */
public class BinarySearchTreeJudgment {
    // 创建一个变量标记上一个节点值
    Integer pre = Integer.MIN_VALUE;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return judgment(root);
    }

    /**
     * 判断传入二叉树是否为二叉搜索树
     *
     * @param root 根节点
     * @return boolean 判断结果
     * @apiNote
     * @since 2023/1/2 13:25
     */
    public boolean judgment(TreeNode root) {
        if (root.left != null) {
            if (!judgment(root.left)) {
                return false;
            }
        }
        // 将当前节点值加入集合
        if (pre >= root.val) {
            return false;
        } else {
            pre = root.val;
        }
        if (root.right != null) {
            return judgment(root.right);
        }
        return true;
    }
}
