package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 两个链表的第一个公共节点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FirstCommonNodeOfTheTwoLinkedLists
 * @apiNote </br>
 * @since 2023/1/30 10:39
 */
public class FirstCommonNodeOfTheTwoLinkedLists {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode flagA = headA;
        ListNode flagB = headB;
        while (flagA != flagB) {
            // 如果当前节点不为空则继续迭代反之则切换到另外一条链表
            flagA = flagA != null ? flagA.next : flagB;
            flagB = flagB != null ? flagB.next : flagA;
        }
        return flagA;
    }
}
