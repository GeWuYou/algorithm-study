package com.gewuyou.algorithm.swordpointstooffer;

import com.gewuyou.algorithm.problem.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SequenceTraversal
 * @apiNote </br>
 * @since 2023/1/25 14:38
 */
public class SequenceTraversal {
    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        // 创建辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 创建辅助集合
        List<Integer> temp = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 将该节点值加入集合
            temp.add(queue.peek().val);
            // 判断该节点是否存在左右子节点
            if (queue.peek().left != null) {
                // 如果该节点存在左子节点则加入队列
                queue.offer(queue.peek().left);
            }
            assert queue.peek() != null;
            if (queue.peek().right != null) {
                // 如果该节点存在右子节点则加入队列
                queue.offer(queue.peek().right);
            }
            // 弹出该节点
            queue.poll();
        }
        // return temp.stream().mapToInt(Integer::valueOf).toArray();
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}
