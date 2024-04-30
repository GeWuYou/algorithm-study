package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树 的层序遍历
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SequentialTraversalOfBinaryTrees
 * @apiNote </br>
 * @since 2022/12/29 20:42
 */
public class SequentialTraversalOfBinaryTrees {
    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public List<ArrayList<Integer>> levelOrder(TreeNode root) {
        // 创建集合
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // 创建辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            // 将根节点加入队列中
            queue.add(root);
        }
        // 层序遍历
        levelOrder(result, queue);
        // 返回结果
        return result;
    }

    /**
     * 对二叉树 进行层序遍历
     *
     * @param result 遍历结果集合
     * @param queue  辅助队列
     * @apiNote
     * @since 2022/12/29 20:52
     */
    public void levelOrder(List<ArrayList<Integer>> result, Queue<TreeNode> queue) {
        // 统计本层节点数
        int size = queue.size();
        if (size == 0) {
            return;
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
            }
            if (queue.peek().right != null) {
                nextQueue.add(queue.peek().right);
            }
            // 将当前节点值加入本层结果集合中
            resultArray.add(queue.poll().val);
        }
        // 将本层结果集合加入结果集合中
        result.add(resultArray);
        // 继续下一层的层序遍历
        levelOrder(result, nextQueue);
    }
}
