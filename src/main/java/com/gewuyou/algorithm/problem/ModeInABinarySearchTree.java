package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 501. 二叉搜索树中的众数
 *
 * @author gewuyou
 * @since 2024-04-19 下午2:24:58
 */
public class ModeInABinarySearchTree {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int max = map.values().stream().max(Integer::compareTo).orElse(0);
        return map.entrySet().stream().filter(entry -> entry.getValue() == max).mapToInt(Map.Entry::getKey).toArray();
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map) {
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (root.left != null) {
            dfs(root.left, map);
        }
        if (root.right != null) {
            dfs(root.right, map);
        }
    }

}
