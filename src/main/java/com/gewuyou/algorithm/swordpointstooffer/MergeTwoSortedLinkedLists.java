package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 合并两个排序的链表
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MergeTwoSortedLinkedLists
 * @apiNote </br>
 * @since 2023/1/30 9:43
 */
public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建新的虚拟头节点
        ListNode virtualHeadNode = new ListNode(Integer.MAX_VALUE);
        // 创建标记节点
        ListNode flag = virtualHeadNode;
        // 遍历两个链表
        while (list1 != null && list2 != null) {
            // 判断两个链表节点数据大小
            if (list1.val < list2.val) {
                flag.next = list1;
                list1 = list1.next;
            } else {
                flag.next = list2;
                list2 = list2.next;
            }
            // 移动标记节点
            flag = flag.next;
        }
        // 如果循环结束仍有链表不为空，直接接在新链表尾部
        if (list1 != null) {
            flag.next = list1;
        }
        if (list2 != null) {
            flag.next = list2;
        }
        return virtualHeadNode.next;
    }
}
