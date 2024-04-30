package com.gewuyou.algorithm.problem;

/**
 * 相同的树
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SameTree
 * @apiNote </br>
 * @since 2023/4/12 21:49
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p, q);
    }

    private boolean check(TreeNode p, TreeNode q) {
        // 递归末尾
        if (p == null && q == null) {
            return true;
        }
        // 如果其中有一个节点为空说明该树不对称
        if (p == null || q == null) {
            return false;
        }
        // 判断当前值是否相同
        if (p.val != q.val) {
            return false;
        }
        // 向左右递归
        return check(p.left, q.left) && check(p.right, q.right);
    }
}
