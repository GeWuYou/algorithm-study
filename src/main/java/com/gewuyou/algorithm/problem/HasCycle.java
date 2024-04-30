package com.gewuyou.algorithm.problem;

/**
 * 牛客网链表有环问题
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName HasCycle
 * @apiNote 使用快慢指针解决链表中有环问题
 * </br>
 * @since 2022/12/18 10:13
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        // 健壮性检验
        if (head == null || head.next == null) {
            return false;
        }
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        //遍历链表，如果快慢指针指向了同一个结点，那么证明有环
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
