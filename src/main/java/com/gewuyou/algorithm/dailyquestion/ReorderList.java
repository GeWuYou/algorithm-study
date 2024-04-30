package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.swordpointstooffer.ListNode;

import java.util.ArrayList;

/**
 * 重排链表
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/7/31 10:19
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ArrayList<ListNode> nodes = new ArrayList<ListNode>();
        ListNode flag = head;
        while (flag != null) {
            nodes.add(flag);
            flag = flag.next;
        }
        int i = 0;
        int j = nodes.size() - 1;
        while (i < j) {
            nodes.get(i).next = nodes.get(j);
            i++;
            if (i == j) {
                break;
            }
            nodes.get(j).next = nodes.get(i);
            j--;
        }
        nodes.get(i).next = null;
    }
}

