package com.gewuyou.algorithm.swordpointstooffer;

import com.gewuyou.algorithm.problem.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BinaryTreeNeutralizesPath2SomeValue
 * @apiNote </br>
 * @since 2023/2/1 11:02
 */
public class BinaryTreeNeutralizesPath2SomeValue {
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        // 创建结果集合
        List<List<Integer>> result = new ArrayList<>();
        // 判空
        if (root == null) {
            return result;
        }
        dfs(root, target, result, new ArrayList<>(), 0);
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param root    根节点
     * @param target  目标值
     * @param result  结果集合
     * @param current 当前结果集合
     * @param sum     和
     * @apiNote
     * @since 2023/2/1 11:07
     */
    public static void dfs(TreeNode root, int target, List<List<Integer>> result, List<Integer> current, int sum) {
        // 如果当前节点为空。或者到达子节点后加入当前值后大于目标值(正数)直接返回或者加入当前值小于目标值(负数)直接返回
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum + root.val > target && target >= 0) {
                return;
            }
            if (sum + root.val < target && target < 0) {
                return;
            }
        }
        // 如果加入当前值后，小于目标值则继续递归并加入当前值
        current.add(root.val);
        // 更新和
        sum += root.val;
        // 如果加入当前值后恰好相等则加入
        if (sum == target && root.left == null && root.right == null) {
            result.add(new ArrayList<>(current));
            // 移除当前值
            current.remove(current.size() - 1);
            return;
        }
        // 向左向右递归
        dfs(root.left, target, result, current, sum);
        dfs(root.right, target, result, current, sum);
        // 移除当前值
        current.remove(current.size() - 1);
    }
}
