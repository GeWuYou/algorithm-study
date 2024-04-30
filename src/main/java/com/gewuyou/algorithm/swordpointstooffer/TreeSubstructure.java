package com.gewuyou.algorithm.swordpointstooffer;

import com.gewuyou.algorithm.problem.TreeNode;

/**
 * 树的子结构
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TreeSubstructure
 * @apiNote </br>
 * @since 2023/1/25 18:51
 */
public class TreeSubstructure {
    public boolean isSubStructure(TreeNode ignoredA, TreeNode ignoredB) {
        // 传入节点不能为空且对A节点与B节点进行判断如果不匹配则递归的对A的左右子树对B进行比对
        return (ignoredA != null && ignoredB != null) && (recur(ignoredA, ignoredB) || isSubStructure(ignoredA.left, ignoredB) || isSubStructure(ignoredA.right, ignoredB));
    }

    boolean recur(TreeNode ignoredA, TreeNode ignoredB) {
        // 对传入节点进行判断

        // 如果B为空则表明B为A的子树
        if (ignoredB == null) {
            return true;
        }
        // 如果A为空或者A值与B值不匹配说明B不是A的子树
        if (ignoredA == null || ignoredA.val != ignoredB.val) {
            return false;
        }

        // 对该节点左右进行递归判断
        return recur(ignoredA.left, ignoredB.left) && recur(ignoredA.right, ignoredB.right);
    }
}
