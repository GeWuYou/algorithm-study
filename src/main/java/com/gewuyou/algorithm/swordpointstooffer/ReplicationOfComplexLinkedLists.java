package com.gewuyou.algorithm.swordpointstooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ReplicationOfComplexLinkedLists
 * @apiNote </br>
 * @since 2023/1/19 17:35
 */
public class ReplicationOfComplexLinkedLists {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        // 判空
        if(head == null){
            return null;
        }
        // 标记当前节点
        Node cur = head;
        // 创建集合记录节点
        Map<Node, Node> map = new HashMap<>();
        // 遍历链表将所有节点加入map集合中
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            // 将传入链表与新链表的节点一一对应
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

