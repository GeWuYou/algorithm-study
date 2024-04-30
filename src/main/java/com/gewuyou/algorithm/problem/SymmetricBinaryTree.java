package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称的二叉树
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SymmetricBinaryTree
 * @apiNote </br>
 * @since 2022/12/31 22:59
 */
public class SymmetricBinaryTree {
    boolean isSymmetrical(TreeNode pRoot) {
        // 创建辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot != null) {
            // 将根节点加入队列中
            queue.add(pRoot);
        }
        // 设置标记确保跳过对根节点的检查
        boolean flag = false;
        // 层序遍历
        return levelOrder(queue, flag);
    }

    /**
     * 对二叉树进行层序遍历判断是否为对称二叉树
     *
     * @param queue 辅助队列
     * @return boolean 遍历结果
     * @apiNote
     * @since 2022/12/31 23:14
     */
    public boolean levelOrder(Queue<TreeNode> queue, boolean flag) {
        // 统计本层节点数
        int size = queue.size();
        // 如果直到全部节点遍历完，说明该二叉树为对称二叉树
        if (size == 0) {
            return true;
        }
        // 如果本层遍历节点数为奇数直接可以判断该二叉树不是对称二叉树
        if (flag && size % 2 == 1) {
            return false;
        }
        // 创建本层结果集合
        ArrayList<Integer> resultArray = new ArrayList<>(size);
        // 创建下层辅助队列
        Queue<TreeNode> nextQueue = new LinkedList<>();
        // 弹出队列节点
        while (!queue.isEmpty()) {
            // 将弹出节点的左 右节点加入新队列中
            if (queue.peek().left != null) {
                nextQueue.add(queue.peek().left);
            } else if (queue.peek().val != Integer.MAX_VALUE) {
                // 如果该节点左子节点为空，加入一个占位节点
                nextQueue.add(new TreeNode(Integer.MAX_VALUE));
            }
            if (queue.peek().right != null) {
                nextQueue.add(queue.peek().right);
            } else if (queue.peek().val != Integer.MAX_VALUE) {
                // 如果该节点右子节点为空，加入一个占位节点
                nextQueue.add(new TreeNode(Integer.MAX_VALUE));
            }
            // 将当前节点值加入本层结果集合中
            resultArray.add(queue.poll().val);
        }
        // 回文检测
        if (size > 1) {
            for (int i = 0; i < resultArray.size(); i++) {
                if (!resultArray.get(i).equals(resultArray.get(resultArray.size() - 1 - i))) {
                    return false;
                }
            }
        }
        // 继续下一层的层序遍历
        return levelOrder(nextQueue, !flag);
    }
}