package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 王位的继承顺序
 *
 * @author gewuyou
 * @since 2024-04-07 下午1:35:04
 */
public class ThroneInheritance {
    private final Node king;
    private final Map<String, Node> record = new HashMap<>();

    public ThroneInheritance(String kingName) {
        king = new Node(kingName);
        record.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Node parent = record.get(parentName);
        Node child = new Node(childName);
        parent.children.add(child);
        record.put(childName, child);
    }

    public void death(String name) {
        record.get(name).isDead = true;
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        // 如果国王没挂
        if (!king.isDead) {
            result.add(king.name);
        }
        dfs(king, result);
        return result;
    }

    private void dfs(Node node, List<String> result) {
        for (Node child : node.children) {
            if (!child.isDead) {
                result.add(child.name);
            }
            dfs(child, result);
        }
    }

    static class Node {
        private boolean isDead;
        private List<Node> children;
        private String name;

        public Node(String name) {
            this.name = name;
            this.children = new ArrayList<>();
            this.isDead = false;
        }
    }
}
