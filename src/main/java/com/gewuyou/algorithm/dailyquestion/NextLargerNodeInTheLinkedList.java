package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.problem.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 链表中的下一个更大节点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NextLargerNodeInTheLinkedList
 * @apiNote </br>
 * @since 2023/4/10 14:07
 */
public class NextLargerNodeInTheLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            recursion(head, list);
            head = head.next;
        }
        return Arrays.stream(list.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }

    private void recursion(ListNode head, List<Integer> list) {
        ListNode flag = head.next;
        // 设定最大值
        int max = head.val;
        while (flag != null) {
            if (flag.val > max) {
                list.add(flag.val);
                return;
            }
            flag = flag.next;
        }
        list.add(0);
    }
}
