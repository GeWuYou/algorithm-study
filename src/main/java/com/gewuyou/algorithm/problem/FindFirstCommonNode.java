package com.gewuyou.algorithm.problem;

/**
 * 两个链表的第一个公共结点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FindFirstCommonNode
 * @apiNote </br>
 * @since 2022/12/19 12:28
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 代码健壮性检验
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        // 定义双指针
        ListNode flag = pHead1;
        ListNode mark = pHead2;

        while (flag != null) {
            while (mark != null) {
                if (mark == flag) {
                    return flag;
                }
                mark = mark.next;
            }
            // 重置mark指针
            mark = pHead2;
            flag = flag.next;
        }
        return null;
    }
}
