package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.problem.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * @author gewuyou
 * @since 2024-07-24 下午8:24:57
 */
public class TheKSmallestElementInTheBinarySearchTree {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.reverseOrder());
        kthSmallest(root, k,pq);
        return pq.peek();
    }

    private void kthSmallest(TreeNode root,int k, PriorityQueue<Integer> pq) {
        if (root == null) {
            return;
        }
        if (pq.size() < k) {
            pq.offer(root.val);
        }else if(root.val <pq.peek()) {
            pq.poll();
            pq.offer(root.val);
        }
        kthSmallest(root.left,k, pq);
        kthSmallest(root.right, k,pq);
    }
}
