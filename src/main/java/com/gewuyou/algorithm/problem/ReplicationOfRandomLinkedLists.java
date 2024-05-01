package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 随机链表的复制
 *
 * @author gewuyou
 * @since 2024-05-09 下午4:32:58
 */
public class ReplicationOfRandomLinkedLists {
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

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node curr = head;
        Node prev = dummy;
        while (curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            prev.next = copy;
            prev = prev.next;
            curr = curr.next;
        }
        curr = head;
        prev = dummy.next;
        while (curr != null) {
            Node random =curr.random;
            if(random!=null){
                prev.random = map.get(random);
            }
            curr = curr.next;
            prev = prev.next;
        }
        return dummy.next;
    }
}
