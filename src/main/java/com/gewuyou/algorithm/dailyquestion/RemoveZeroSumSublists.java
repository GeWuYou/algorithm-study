package com.gewuyou.algorithm.dailyquestion;


import com.gewuyou.algorithm.swordpointstooffer.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从链表中删去总和值为零的连续节点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RemoveZeroSumSublists
 * @apiNote </br>
 * @since 2023/6/11 10:13
 */
public class RemoveZeroSumSublists {
    public ListNode removeZeroSumSublists(ListNode head) {
        // 创建虚拟头节点
        ListNode virtualHeadNode = new ListNode(0);
        virtualHeadNode.next = head;
        // 创建集合
        Map<Integer,ListNode> seen = new HashMap<>();
        // 记录前缀和
        int prefix = 0;
        for(ListNode node = virtualHeadNode;node != null;node = node.next) {
            prefix +=node.val;
            seen.put(prefix, node);
        }
        prefix = 0;
        for (ListNode node = virtualHeadNode;node != null;node = node.next){
            prefix +=node.val;
            node.next = seen.get(prefix).next;
        }
        return virtualHeadNode.next;
    }
}
