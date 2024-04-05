package com.gewuyou.algorithm.dailyquestion;



/**
 * 705. 设计哈希集合
 *
 * @author gewuyou
 * @since 2024-04-14 上午10:23:15
 */
public class MyHashSet {
    static class Node {
        Integer value;
        Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }
    private static final int DEFAULT_SIZE = 16;
    private Node[] nodes;

    public MyHashSet() {
        nodes = new Node[DEFAULT_SIZE];
    }

    public void add(int key) {
        // 计算哈希值
        int index = hash(key);
        // 判断索引是否超出范围
        if (index >= nodes.length) {
            resize();
        }
        // 查看此处的节点是否为空
        Node node = nodes[index];
        if (node == null) {
            nodes[index] = new Node(key);
            return;
        }
        while (node != null) {
            if (node.value == key) {
                return;
            }
            node = node.next;
        }
        // 如果此处的节点为空则插入新节点
        Node newNode = new Node(key);
        newNode.next = nodes[index];
        nodes[index] = newNode;
    }

    private void resize() {
        int newSize = nodes.length * 2;
        Node[] newNodes = new Node[newSize];
        // 重新计算哈希值并插入元素
        for (Node node : nodes) {
            while (node != null) {
                // 记录下一个节点的引用
                Node next = node.next;
                // 计算当前节点的位置
                int index = hash(node.value);
                // 如果此处有节点存在则将当前节点的下一节点指向它
                node.next = newNodes[index];
                // 取代原来的节点如果有的话
                newNodes[index] = node;
                // 移动到下一个节点
                node = next;
            }
        }
    }

    public void remove(int key) {
        int index = hash(key);
        Node node = nodes[index];
        Node prev = null;
        while (node != null) {
            if (node.value == key) {
                if (prev == null) {
                    nodes[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        Node node = nodes[index];
        while (node != null) {
            if (node.value == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    // 哈希函数
    private int hash(Integer value) {
        return Math.abs(value.hashCode() % nodes.length);
    }
}
