package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 *
 * @author gewuyou
 * @since 2024-05-18 下午3:25:21
 */
public class RightViewOfTheBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        stack.offer(root);
        while (!stack.isEmpty()) {
            // 计算当前层的节点数
            int size = stack.size();
            // 创建临时集合
            List<Integer> temp = new ArrayList<>();
            // 遍历当前层的节点
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.poll();
                assert node != null;
                if(node.left!= null){
                    temp.add(node.left.val);
                    stack.offer(node.left);
                }
                if(node.right!= null){
                    temp.add(node.right.val);
                    stack.offer(node.right);
                }
            }
            // 将当前层的最右边的节点添加到结果集
            if (!temp.isEmpty()){
                res.add(temp.getLast());
            }
        }
        return res;
    }
}
