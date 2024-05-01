package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 133. 克隆图
 *
 * @author gewuyou
 * @since 2024-05-08 下午1:02:42
 */
public class CloneDiagram {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
       return cloneGraphHelper(node, new HashMap<>());
    }

    private Node cloneGraphHelper(Node node, Map<Node, Node> nodeNodeHashMap) {
        if(node==null){
            return null;
        }
        if(nodeNodeHashMap.containsKey(node)){
            //已经克隆过了
            return nodeNodeHashMap.get(node);
        }
        Node newNode = new Node(node.val);
        // 存储已经克隆了的节点
        nodeNodeHashMap.put(node, newNode);
        for(Node neighbor:node.neighbors){
            // 递归克隆邻居节点
            newNode.neighbors.add(cloneGraphHelper(neighbor, nodeNodeHashMap));
        }
        return newNode;
    }
}
