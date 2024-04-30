package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.problem.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删点成林
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName DeleteTheDotsIntoForests
 * @apiNote </br>
 * @since 2023/5/30 11:44
 */
public class DeleteTheDotsIntoForests {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> nodes = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        recursion(root,set,nodes,true);
        return nodes;
    }

    private TreeNode recursion(TreeNode root, Set<Integer> set, List<TreeNode> nodes, boolean isRoot) {
        if(root==null){
            return null;
        }
        // 判断当前节点是否为需要删除的节点
        boolean deleted = set.contains(root.val);
        root.left = recursion(root.left,set,nodes,deleted);
        root.right = recursion(root.right,set,nodes,deleted);
        if(deleted){
            return null;
        }else {
            if(isRoot){
                nodes.add(root);
            }
            return root;
        }
    }
}
