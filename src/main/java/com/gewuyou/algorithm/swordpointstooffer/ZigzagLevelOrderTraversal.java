package com.gewuyou.algorithm.swordpointstooffer;

import com.gewuyou.algorithm.problem.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 之字形层序遍历
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ZigzagLevelOrderTraversal
 * @apiNote </br>
 * @since 2023/1/25 15:34
 */
public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 创建集合
        List<List<Integer>> result = new ArrayList<>();
        // 创建辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            // 将根节点加入队列中
            queue.add(root);
        }
        // 层序遍历
        levelOrder(result, queue, 1);
        // 返回结果
        return result;
    }

    /**
     * 对二叉树进行之字形层序遍历
     *
     * @param result 结果集合
     * @param queue  当层辅助队列
     * @param layers 当前层数
     * @apiNote
     * @since 2022/12/30 19:39
     */
    public void levelOrder(List<List<Integer>> result, Queue<TreeNode> queue, int layers) {

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
        // 如果是偶数层，将结果集合反转
        if (layers % 2 == 0) {
            reverseArray(resultArray);
        }
        // 将本层结果集合加入结果集合中
        result.add(resultArray);
        // 层数递增
        layers++;
        // 继续下一层的层序遍历
        levelOrder(result, nextQueue, layers);

    }

    /**
     * 反转集合
     *
     * @param resultArray 结果集合
     * @apiNote
     * @since 2022/12/30 19:43
     */
    public void reverseArray(List<Integer> resultArray) {
        // 计算结果集合长度
        int size = resultArray.size();
        // 创建辅助数组
        Integer[] newArray = new Integer[size];
        int count = 0;
        for (Integer integer : resultArray) {
            newArray[count++] = integer;
        }
        resultArray.clear();
        // 反转集合
        for (int i = count - 1; i >= 0; i--) {
            resultArray.add(newArray[i]);
        }
    }
}
